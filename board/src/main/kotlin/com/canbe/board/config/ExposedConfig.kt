package com.canbe.board.config

import org.jetbrains.exposed.spring.autoconfigure.ExposedAutoConfiguration
import org.jetbrains.exposed.sql.DatabaseConfig
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

// 해당 Config 설정 자세히 공부하기 !
// Transaction Manager / DataSource 차이점 알기 !!

//@Configuration
//@ImportAutoConfiguration(
//    value = [ExposedAutoConfiguration::class],
//    exclude = [DataSourceTransactionManagerAutoConfiguration::class]
//)
//class ExposedConfig {
//    @Bean
//    fun databaseConfig(): DatabaseConfig {
//        return DatabaseConfig {
//            useNestedTransactions = true
//        }
//    }
//}
