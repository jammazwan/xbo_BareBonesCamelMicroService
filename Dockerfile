FROM java:8-jdk
MAINTAINER jammazwan <pete@datafundamentals.com> "https://github.com/jammazwan"
WORKDIR /usr/lib
ADD target/barebonescamel.jar /usr/lib
ENV JAR_LOCATION .
ENV JAR_NAME barebonescamel.jar
CMD [ "java", "-jar", "barebonescamel.jar" ]