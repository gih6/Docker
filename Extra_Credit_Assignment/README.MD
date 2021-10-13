
# Sentiment Analysis

Link to Demo is here: https://pitt.zoom.us/rec/share/Zbib8WgsCpPTLjpLMOJuAR2zjU4_Vk5hKULLLrh4rt1m0zCziy9WflSx8I6P2lMF.rHqiawCtnvJI6U0c?startTime=1634090290000


Also Uploaded to Google Drive here: https://drive.google.com/file/d/1LrKA5N6McUZB46r7nu3zt0SKFWzQ7CkX/view?usp=sharing

### Docker Links are below: 

Frontend: https://hub.docker.com/r/gih6/sentiment-analysis-frontend (Both normal and minikube tag)

Sentimental: https://hub.docker.com/r/gih6/sentiment-analysis-logic 

Web App: https://hub.docker.com/r/gih6/sentiment-analysis-web-app 

### Running on Kubernetes Google Cloud Engine:

![Screen Shot 2021-10-12 at 10 08 20 PM](https://user-images.githubusercontent.com/54678622/137055139-ff9f6cb5-c189-402f-b44f-157c21ccf741.png)

![Screen Shot 2021-10-12 at 10 08 05 PM](https://user-images.githubusercontent.com/54678622/137055154-1003463e-c5e5-4c4e-b03f-95da176e15bf.png)

### Steps to run Kubernetes on Google Cloud Engine:

First Set up and run a cluster from the GKE (Make sure gcloud was initialized on cloudshell in correct time zone and kubernetes API is enabled)

>$ gcloud container clusters get-credentials cluster-1 --zone us-central-c --project elegant-tide-326122

>$ kubectl create -f service-sa-frontend-lb.yaml

>$ kubectl apply -f sa-frontend-deployment.yaml

>$ kubectl apply -f sa-logic-deployment.yaml --record

>$ kubectl create -f service-sa-logic.yaml --record

>$ kubectl apply -f sa-web-app-deployment.yaml --record

>$ kubectl create -f sa-web-app-deployment.yaml

>$ kubectl create -f service-sa-web-app-lb.yaml

>$kubectl get svc (This is where need to change IP inside APP.js to the sa-web-app-lb

>$ kubectl apply -f sa-frontend-deployment.yaml


### Code Changed Specifically in App.js


