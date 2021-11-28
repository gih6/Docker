import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TopNFrequencies {
    //key is the TERM value is the Count & Document it is from!!
    public static class TokenizerMapper
            extends Mapper<Object, Text, Text, IntWritable>{
        Map<String,Integer> count = new HashMap<String,Integer>();
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(value.toString().toLowerCase().replaceAll("\\d","").replaceAll("[^a-zA-Z ]",""));
            while (itr.hasMoreTokens()) {
                String wordDoc = itr.nextToken();
                if(count.containsKey(wordDoc)){
                    count.put(wordDoc,count.get(wordDoc)+1); // adding to existing on
                }else {
                    count.put(wordDoc, 1); //first instance of word in file
                }
            }

            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                word.set(entry.getKey());
                IntWritable test = new IntWritable(entry.getValue());
                context.write(word, test);
            }
        }
    }
    public static class KeyComparator extends WritableComparator {
        protected KeyComparator(){
            super(IntWritable.class,true);
        }
    }
    public int compare(WritableComparable w1, WritableComparable w2){
        IntWritable ip1 = (IntWritable) w1;
        IntWritable ip2 = (IntWritable) w2;
        return w1.compareTo(w2);
    }



    public static class IntSumReducer
            extends Reducer<Text,IntWritable,Text,IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values,
                           Context context
        ) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Top N Frequency");
        job.setJarByClass(TopNFrequencies.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setReducerClass(IntSumReducer.class);
        job.setNumReduceTasks(1);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //adding multiple files. to this path try this !
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

//Notes on the Inverting Indexes:
//want  to sort by BOTH FOLDER and FILE NAME and by WORD!! -- need to modify this as such
