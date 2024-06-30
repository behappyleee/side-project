package com.canbe.board

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceTransactionManagerAutoConfiguration::class])
class BoardApplication

fun main(args: Array<String>) {
    runApplication<BoardApplication>(*args)
}
