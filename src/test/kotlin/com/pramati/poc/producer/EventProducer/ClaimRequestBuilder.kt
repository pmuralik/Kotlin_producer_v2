package com.pramati.poc.producer.EventProducer

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

class ClaimRequestBuilder (private val mockMvc: MockMvc)
{

    private val objectMapper = WebTestConfig.objectMapper()

    fun create(input: NewClaim): ResultActions {
        return mockMvc.perform(MockMvcRequestBuilders.post("/newClaim")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(input))
        )
    }
}