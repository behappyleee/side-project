package com.canbe.board.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager


@Configuration
class JpaConfig {

    // TODO - Jpa Transaction Manager 제대로 설정해주어야 함 ! ---> 현재 Exposed 는 조회 안 됨 !
    @Bean(name = ["transactionManager"])
    fun dbTransactionManager(): PlatformTransactionManager {
        return JpaTransactionManager()
    }
}
