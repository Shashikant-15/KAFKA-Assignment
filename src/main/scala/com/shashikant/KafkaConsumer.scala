
package com.shashikant
import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}

import java.io.{BufferedWriter, FileWriter}
import java.util.{Collections, Properties}
import scala.collection.JavaConverters._

object KafkaConsumer  extends App {

  val property = new Properties()


  property.put("bootstrap.servers", "localhost:9092")


  property.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")


  property.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")


  property.put("group.id", "consumer-group-1")


  property.put("enable.auto.commit", "true")


  property.put("auto.commit.interval.ms", "1000")
  property.put("auto.offset.reset", "earliest")


  property.put("session.timeout.ms", "30000")


  val topic = "kafka-topic-kipp1"


  val Consumer: KafkaConsumer[Nothing, String] = new KafkaConsumer[Nothing, String](property)


  Consumer.subscribe(Collections.singletonList(topic))
  println("Consumer Consuming")


  while (true) {

    val reco: ConsumerRecords[Nothing, String] = Consumer.poll(100)
    for (reco<- reco.asScala) {

      val buf  = new BufferedWriter(new FileWriter("target/employee.txt", true))
      buf.write("\n" + reco.value)
      buf.close()
      println(reco.value)
    }
  }
}



