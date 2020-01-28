package com.pramati.poc.producer.EventProducer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CliamRepository : JpaRepository<Claim, String> {
}