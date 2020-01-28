package com.pramati.poc.producer.EventProducer

import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import io.mockk.mockk
import org.hamcrest.Matchers.equalTo
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Tag
import org.mockito.internal.matchers.Matches
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import java.time.Instant

@Tag("unitTest")
class ClaimControllerTest {


    private lateinit var clientService: ClientService
    private lateinit var cliamRepository: CliamRepository
    private lateinit var requestBuilder: ClaimRequestBuilder

    var newClaim = NewClaim("Rajesh", "12")


    @Before
    fun configureSystemUnderTest() {
        cliamRepository = mockk()
        clientService = ClientService(cliamRepository)

        val mockMvc = MockMvcBuilders.standaloneSetup(ProducerController(clientService))
                .setLocaleResolver(WebTestConfig.fixedLocaleResolver())
                .setMessageConverters(WebTestConfig.objectMapperHttpMessageConverter())
                .build()
        requestBuilder = ClaimRequestBuilder(mockMvc)
    }



    @Test
    fun shouldSuccess() {
        every { cliamRepository.save(any() ) } returns Claim(
                claimId = newClaim.claimId,
                createdBy = newClaim.createdBy,
                createdDate = Instant.now()
        )

        requestBuilder.create(newClaim)
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.consumed",equalTo(false)))

    }
}