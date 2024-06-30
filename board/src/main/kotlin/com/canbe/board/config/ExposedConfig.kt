package com.canbe.board.config

import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

// 해당 Config 설정 자세히 공부하기 !
// Transaction Manager / DataSource 차이점 알기 !!
@Configuration
class ExposedConfig {

    @Bean(name = ["exposedTransactionManager"])
    fun transactionManager(dataSource: DataSource): PlatformTransactionManager {
        return SpringTransactionManager(dataSource = dataSource)
    }
}
