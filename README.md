This project demonstrates a multi-tenant architecture using Apache Kafka to handle end-to-end (E2E) testing scenarios. It showcases how a shared environment can be used with isolated tenant data processing, ensuring that messages for different tenants are processed independently.

#Steps to Get Started

Step 1: Start ZooKeeper
ZooKeeper is used by Kafka to manage distributed configurations. Start ZooKeeper using the following command

zookeeper-server-start.sh /usr/local/etc/kafka/zookeeper.properties

Step 2: Start Kafka
Start the Kafka server using the following command:

sh
kafka-server-start.sh /usr/local/etc/kafka/server.properties

Step 3: Create a Multi-Tenant Aware Topic
Create a Kafka topic named shared-topic:

sh
kafka-topics.sh --create --topic shared-topic --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1

Step 4: Build the Project
Navigate to the project directory and run the following command to clean and package the project using Maven:

sh
mvn clean package

Step 5: Start the Consumers
Start the Tenant1Consumer and Tenant2Consumer in separate terminal windows:

sh
java -cp target/your-jar-name.jar com.example.Tenant1Consumer
sh
java -cp target/your-jar-name.jar com.example.Tenant2Consumer

Step 6: Run the Producer
Run the TenantAwareProducer to send messages to the shared-topic:

sh
java -cp target/your-jar-name.jar com.example.TenantAwareProducer
