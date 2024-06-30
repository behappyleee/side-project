package com.canbe.openapidata.client

import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

class ClientTest {

    // TODO - Exception 모듈 고민 하기 .... !!
    fun test() {
        WebClient
            .create("baseUrl")
            .get()
            .retrieve()
            .bodyToMono<String>()
            .block() ?: throw RuntimeException("This is Client Exception !!")
    }
}