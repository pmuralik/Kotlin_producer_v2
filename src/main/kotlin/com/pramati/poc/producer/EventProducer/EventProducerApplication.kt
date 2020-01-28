package com.pramati.poc.producer.EventProducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication

class EventProducerApplication

fun main(args: Array<String>) {
	runApplication<EventProducerApplication>(*args)
}
