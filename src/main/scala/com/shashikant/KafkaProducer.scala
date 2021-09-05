package com.shashikant
import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import java.util.Scanner
import io.circe.syntax.EncoderOps
import io.circe.generic.auto._
object Kafka_for_Producer  extends App {
  val scanner = new Scanner(System.in)
  val property = new Properties()

  /**...bootstrap.servers : A list of host/port pairs to use for establishing the initial connection to the Kafka... */


  property.put("bootstrap.servers", "localhost:9092")
  property.put("client.id", "ScalaProducerExample")
  property.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  property.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")


  property.put("acks", "1")
  property.put("retries", "0")
  property.put("batch.size", "16384")
  property.put("linger.ms", "1")
  property.put("buffer.memory", "33554432")


  /**...A producer is instantiated by providing the configuration....**/


  val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](property)

    /**....Created  The topic where record should be sent ....*/

  val topic = "kafka-topic-kipp1"
  println("Sending the Records in Kafka-Topic [$topic]")


  for (i <- 1 to 10) {
    val record: ProducerRecord[String, String] =
      new ProducerRecord(topic,
        i.toString,
        createUserMessage(i).asJson.toString)
    println(record)
    producer.send(record)
  }

      /** .. producer  method blocks all , until all previously sent requests doesn't complete...*/

  producer.close()



    /**...This  Method is used for creating the user message for every records.......*/

  def createUserMessage(id: Int): Student ={
    var name = ""
    var course = ""
    var age = 0
    println("Enter the name")
    name = scanner.nextLine()

    println("Enter the course")
    course = scanner.nextLine()

    println("Enter the age")
    age = scanner.nextInt()
    scanner.nextLine()

    val student = Student( id,name,
      course,
      age.toInt)
    student
  }
}


    /**...Case class used for implementation the user's details filled...**/

case class Student(id: Int,
                   name: String,
                   course: String,
                   age: Int)
