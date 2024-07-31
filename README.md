
**Project Description**

This project demonstrates a multi-tenant architecture using Apache Kafka to handle end-to-end (E2E) testing scenarios. It showcases how a shared environment can be used with isolated tenant data processing, ensuring that messages for different tenants are processed independently.

## Components

### **Message Class**

A simple POJO representing messages with tenant metadata (`tenant_id`) and data (`data`). 


### **Tenant1Consumer and Tenant2Consumer**

Kafka consumers configured for two different tenant groups (`tenant1` and `tenant2`). Each consumer subscribes to the same Kafka topic (`shared-topic`) and processes messages specific to their tenant.

- **Tenant1Consumer**: 
  - Processes messages where `tenant_id` is `tenant1`.

- **Tenant2Consumer**:
  - Processes messages where `tenant_id` is `tenant2`.

### **TenantAwareProducer**

A Kafka producer that sends messages with tenant metadata to the shared topic.
  - Messages are serialized into JSON format before being sent to the Kafka topic.


## Requirements

- **Apache Kafka**: Required for message brokering and streaming.

- **Apache ZooKeeper**: Required for managing and coordinating Kafka brokers.

- **Java 8 or higher**: Required for running the Kafka and Java-based components.

- **Maven**: Required for building and managing dependencies of the Java project.


## Steps to Get Started

### **Step 1: Start ZooKeeper**

ZooKeeper is used by Kafka to manage distributed configurations. Start ZooKeeper using the following command:

![Start ZooKeeper](https://github.com/user-attachments/assets/f1c5c1fb-a48e-41f5-9e39-b39225fdfe5c)

### **Step 2: Start Kafka**

Start Kafka using the command:

![Start Kafka](https://github.com/user-attachments/assets/cd75d8e4-daea-478b-a1dd-319c7237dba0)

### **Step 3: Create a Multi-Tenant Aware Topic**

Create a Kafka topic named `shared-topic`:

![Create Topic](https://github.com/user-attachments/assets/3e447f3e-843e-43e7-bb38-6a72c4fd92dd)

### **Step 4: Build the Project**

Navigate to the project directory and run the following command to clean and package the project using Maven:

```bash
mvn clean package
```
![image](https://github.com/user-attachments/assets/32e39c32-9825-4716-8870-ac0bfe6f2982)



### **Step 5:  Run the Producer**

Run the TenantAwareProducer to send messages to the shared-topic:

![image](https://github.com/user-attachments/assets/1e77638e-c7da-4c9e-a3b6-229c101226d0)


### **Step 6: Start the Consumers**

Start the Tenant1Consumer and Tenant2Consumer in separate terminal windows:

![image](https://github.com/user-attachments/assets/763b8574-f3e7-41be-b04e-c855944c38b6)

![image](https://github.com/user-attachments/assets/e0c72d09-164d-414d-ac98-b14defb68f1d)


