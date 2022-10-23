FROM khipu/openjdk17-alpine
MAINTAINER 余江俊
ADD build/libs/raytine-account-1.0-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT ["java","-jar","/opt/app.jar","&"]