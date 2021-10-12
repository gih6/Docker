
# Extra Credit Assignment

### This is an image of the application working locally on the computer:

![working_on_local_2](https://user-images.githubusercontent.com/54678622/137012921-e5dad229-3217-486f-852b-82b3fef5cb9a.PNG)

### Docker Links are below: 

Frontend: https://hub.docker.com/r/gih6/sentiment-analysis-frontend (Both normal and minikube tag)

Sentimental: https://hub.docker.com/r/gih6/sentiment-analysis-logic 

Web App: https://hub.docker.com/r/gih6/sentiment-analysis-web-app 

### Running on Kubernetes Google Cloud Engine:

![CLOUD_PUBLIC IP](https://user-images.githubusercontent.com/54678622/137013074-6a94414d-4ee3-4414-b48d-9436f73377a2.PNG)

 ![SENTIMENT_WORKING ON CLOUD](https://user-images.githubusercontent.com/54678622/137013239-b2bedf1d-b94e-4098-86cf-a79e2925587d.PNG)

### Steps to run Kubernetes on Google Cloud Engine:

First Set up and run a cluster from the GKE (Make sure gcloud was initialized on cloudshell in correct time zone and kubernetes API is enabled)

>$ gcloud container clusters get-credentials cluster-1 --zone us-central-c --project elegant-tide-326122

>$ kubectl create -f service-sa-frontend-lb.yaml

>$ kubectl apply -f sa-frontend-deployment.yaml

>$ kubectl apply -f sa-logic-deployment.yaml --record

>$ kubectl create -f service-sa-logic.yaml --record

>$ kubectl apply -f sa-web-app-deployment.yaml --record

>$ kubectl create -f sa-web-app-deployment.yaml

HERE need to create the new sa-frontend with the minikube tag with updated IP of the web app ip address.

>$ kubectl apply -f sa-frontend-deployment.yaml




