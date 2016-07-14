mvn clean package
docker build -t jammazwan/barebones .
docker run -it -d --name jamzbare jammazwan/barebones
#docker logs -f $(docker ps -lq)