package com.canbe.board.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    transactionManagerRef = "jpaTransactionManager",
    basePackages = ["com.canbe.board.repository"],
)
class JpaConfig {

    // TODO - Jpa Transaction Manager 제대로 설정해주어야 함 ! ---> 현재 Exposed 는 조회 안 됨 !
    @Bean(name = ["jpaTransactionManager"])
    fun transactionManager(): PlatformTransactionManager {
        return JpaTransactionManager()
    }
}
