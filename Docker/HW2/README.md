HW 2:
1. URL Of the Docker File: https://hub.docker.com/repository/docker/gih6/hwtwo (note docx has screenshots of creating and running on local machine)

![hw2_part1_HelloWorld_Create_and_push](https://user-images.githubusercontent.com/54678622/134990980-db5e5858-1d80-484a-98b7-bf6e28837116.PNG)

2a. The Docker Contents are listed here below (file also attached):

FROM openjdk:7
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac helloWorld.java
CMD ["java", "helloWorld"]

2b. The Hello World Text is here:

class helloWorld {
    public static void main(String args[]) {
        System.out.println("Hello World");
    }
}

3. Screen Shot of running in GCB:
(Have it uploaded in GCB) 

![success_push_GCP](https://user-images.githubusercontent.com/54678622/134097061-92495b55-174f-49e5-96cb-202ccdd8eb3d.PNG)

![cloud_run_Working](https://user-images.githubusercontent.com/54678622/134429016-0ececc26-450b-41ee-a76b-2b58c20d8814.PNG)

![gcloud run console](https://user-images.githubusercontent.com/54678622/135461634-80e6fc6d-c172-41c8-a48c-d0599a482a24.PNG)

![failed docker cloud image 2](https://user-images.githubusercontent.com/54678622/135461642-2e23b1b4-077e-4808-9df1-fea4ae707a9c.PNG)


4. Downloading and running Jupityr Notebook:


![image](https://user-images.githubusercontent.com/54678622/133949043-672ec7f8-3442-4e38-97c5-8611d47996f0.png)

EXTRA CREDIT: Running on Kubernetes Cluster

![kluster_create](https://user-images.githubusercontent.com/54678622/135461955-7fb9b24a-5b9b-4ab5-b726-318efcb3b0dc.PNG)

![run_hello_onKube](https://user-images.githubusercontent.com/54678622/134920290-01bf8a9d-530d-4540-b54c-b035447376e6.PNG)

![run_on_kubernetes](https://user-images.githubusercontent.com/54678622/134920304-196033fc-2715-43f4-850c-4b7a53e024f1.PNG)

