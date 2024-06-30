package com.canbe.openapidata.client

import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.service.annotation.GetExchange

interface ClientInterfaceTest {

    @GetExchange("/test")
    fun getTest(@RequestHeader(HttpHeaders.AUTHORIZATION) test: String)
}