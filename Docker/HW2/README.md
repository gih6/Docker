HW 2:
1. URL Of the Docker File: https://hub.docker.com/repository/docker/gih6/hwtwo (note docx has screenshots of creating and running on local machine)
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

![hw2_part1_HelloWorld_Create_and_push](https://user-images.githubusercontent.com/54678622/134097034-3d46b81e-a823-4a18-9a52-aef64f1940c0.PNG)


4. Downloading and running Jupityr Notebook:


![image](https://user-images.githubusercontent.com/54678622/133949043-672ec7f8-3442-4e38-97c5-8611d47996f0.png)


