# cs687_kafka_springboot
Capstone Project 

# How to execute in Local
1. Clone the project to local
2. Install and start Kafka to local by following the link below
    - https://kafka.apache.org/quickstart
3. Install and start Postgres locally by following the link below
    - https://www.postgresql.org/
4. Create a table called customerinfo in the postgres table
5. Build java project and start it locally
6. Use the below curl command to send a message for testing
- curl --location --request POST 'http://localhost:1338/kafka/publish' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"City",
    "lastName":"University"
}'


