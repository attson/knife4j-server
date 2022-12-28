FROM openjdk:17-jdk-slim

ENV JAR_PATH="build/libs/knife4j-server-0.0.1.jar"

COPY $JAR_PATH /opt/application.jar

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ENV JAVA_OPTS='-XX:MaxRAMPercentage=65.0 \
-XshowSettings:vm \
-showversion \
-Xlog:gc*:/var/log/gc.log::filecount=10,filesize=100M \
-XX:NativeMemoryTracking=summary \
-XX:+PrintCommandLineFlags \
-Duser.timezone=Asia/Shanghai'

ENTRYPOINT exec java $JAVA_OPTS -jar /opt/application.jar