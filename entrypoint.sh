#!/bin/bash

set -x

sed -i "s#&&port&&#$PORT#g" /app/application-${SPRING_PROFILES_ACTIVE}.yml

cat /app/application-${SPRING_PROFILES_ACTIVE}.yml

exec mvn spring-boot:run -f /app/pom.xml
