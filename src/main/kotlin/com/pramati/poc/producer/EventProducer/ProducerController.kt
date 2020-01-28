package com.pramati.poc.producer.EventProducer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
class ProducerController(private var clientService: ClientService) {

    @RequestMapping("/")
    fun index() = "This is the producer Application !"

    @PostMapping("/newClaim")
    fun createClaim(@RequestBody newClaim: NewClaim): Claim {
        val claim = Claim(
                createdBy = newClaim.createdBy,
                claimId = newClaim.claimId,
                createdDate = Instant.now(),
                consumed = false
        )

        clientService.saveClaim(claim)

        return claim
    }
}