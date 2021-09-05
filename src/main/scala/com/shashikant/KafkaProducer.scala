package com.shashikant
import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import java.util.Scanner
import io.circe.syntax.EncoderOps
import io.circe.generic.auto._
object Kafka_for_Producer  extends App {
  val scanner = new Scanner(System.in)
  val property = new Properties()


  property.put("bootstrap.servers", "localhost:9092")


  property.put("client.id", "ScalaProducerExample")


  property.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")


  property.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")



  property.put("acks", "1")


  property.put("retries", "0")

  property.put("batch.size", "16384")


  property.put("linger.ms", "1")


  property.put("buffer.memory", "33554432")


  val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](property)


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


  producer.close()
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

case class Student(id: Int,
                   name: String,
                   course: String,
                   age: Int)
