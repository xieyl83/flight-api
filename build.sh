rm -rf /Users/xieyongli/Documents/GitHub/FullStack25Q2/flight-api/src/main/resources/static/*
cp -rpf /Users/xieyongli/Documents/GitHub/FullStack25Q2/flight-client/dist/* /Users/xieyongli/Documents/GitHub/FullStack25Q2/flight-api/src/main/resources/static
. .env
# ./mvnw clean package -DskipTests
./mvnw clean package
