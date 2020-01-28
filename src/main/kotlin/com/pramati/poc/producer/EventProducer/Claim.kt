package com.pramati.poc.producer.EventProducer

import com.fasterxml.jackson.annotation.JsonCreator
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class  Claim(
        val createdBy: String,
        @Id
        val claimId: String,
        val createdDate: Instant,
        var consumed: Boolean = false
)

data class NewClaim @JsonCreator constructor(
        val createdBy: String,
        val claimId: String
)