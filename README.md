This project demonstrates a multi-tenant architecture using Apache Kafka to handle end-to-end (E2E) testing scenarios. It showcases how a shared environment can be used with isolated tenant data processing, ensuring that messages for different tenants are processed independently.

Components:
Message Class:

A simple POJO representing messages with tenant metadata (tenant_id) and data (data).
Tenant1Consumer and Tenant2Consumer:

Kafka consumers configured for two different tenant groups (tenant1 and tenant2).
Each consumer subscribes to the same Kafka topic (shared-topic) and processes messages specific to their tenant.
Example: Tenant1Consumer processes messages where tenant_id is tenant1, while Tenant2Consumer processes messages where tenant_id is tenant2.
TenantAwareProducer:

A Kafka producer that sends messages with tenant metadata to the shared topic.
Demonstrates how to create and send tenant-specific messages to Kafka.
Messages are serialized into JSON format before being sent to the Kafka topic.

#Steps to Get Started

Step 1: Start ZooKeeper
ZooKeeper is used by Kafka to manage distributed configurations. Start ZooKeeper using the following command

![image](https://github.com/user-attachments/assets/f1c5c1fb-a48e-41f5-9e39-b39225fdfe5c)


Step 2: Start Kafka
![image](https://github.com/user-attachments/assets/cd75d8e4-daea-478b-a1dd-319c7237dba0)



Step 3: Create a Multi-Tenant Aware Topic
Create a Kafka topic named shared-topic:
![image](https://github.com/user-attachments/assets/3e447f3e-843e-43e7-bb38-6a72c4fd92dd)


Step 4: Build the Project
Navigate to the project directory and run the following command to clean and package the project using Maven:

mvn clean package
![image](https://github.com/user-attachments/assets/7cc9b688-a72b-42aa-8eab-f284b694c26f)

![image](https://github.com/user-attachments/assets/2f57ee48-0906-4b02-bf42-bbe8b76f88c2)


Step 5: Start the Consumers
Start the Tenant1Consumer and Tenant2Consumer in separate terminal windows:

![image](https://github.com/user-attachments/assets/393e0e86-a6d0-44fe-968e-9461830c17d6)

![image](https://github.com/user-attachments/assets/1f127070-ca05-4d56-91d3-c4d6df5cac1b)


Step 6: Run the Producer
Run the TenantAwareProducer to send messages to the shared-topic:
![image](https://github.com/user-attachments/assets/b027fd27-6414-413e-add0-62e680aadf95)
