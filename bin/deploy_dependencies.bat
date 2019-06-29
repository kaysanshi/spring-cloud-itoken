cd ..
cd itoken-common
call mvn clean package deploy

cd ..
cd itoken-common-domian
call mvn clean package deploy

cd ..
cd itoken-common-service
call mvn clean package deploy

cd ..
cd itoken-common-web
call mvn clean package deploy

cd ..