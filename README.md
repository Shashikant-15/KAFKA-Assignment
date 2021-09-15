
## KAFKA-Assignment

## README
To Clone the git repository
```bash
git clone https://github.com/Shashikant-15/KAFKA-Assignment.git
```


### To Start the Zookeeper Server and Kafka Server

* Change directory to the directory where Apache Kafka is downloaded 
* execute the following command to start the Zookeeper Server.
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### In a new terminal execute the following command to start the Kafka Server.
```bash
bin/kafka-server-start.sh config/server.properties
```

### KAFKA-Assignments is:
* Produce a user message into a Kafka topic and consume it using the Kafka Producer and Consumer APIs. Once the message is consumed from a consumer, it should be sinked(written) into a file.
* Message Structure
* User message --->{"id":"1","name":"some_name","age":"24","course":"BTech."}
#### Produce and Consume User Message
1. Execute the Consumer Class to start the Consumer
2. Execute the Producer Class to start the Producer
3. Open the UserData.txt file and check if the message produced by the producer is stored in the file.
