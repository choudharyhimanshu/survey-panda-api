FROM maven:3.6.2-jdk-8

COPY . /app

RUN chmod +x /app/entrypoint.sh

WORKDIR /app

RUN mvn clean install

CMD /app/entrypoint.sh
