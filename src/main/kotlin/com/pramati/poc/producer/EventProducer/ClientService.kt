package com.pramati.poc.producer.EventProducer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientService {

    @Autowired
    lateinit var claimRepository: CliamRepository

    fun saveClaim(claim: Claim) {
        claimRepository.save(claim)
        println("Claim Saved")
    }
}