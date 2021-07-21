FROM java:8-jre

ADD ./target/Demoapp.jar /app/
CMD ["java", "-Xmx1000m", "-jar", "-Dspring.config.location=/etc/config/application.properties", "/app/Demoapp.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]

EXPOSE 8080