package com.canbe.openapidata.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpSession
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World !"
    }

    @PostMapping("/user/session")
    fun createSession(
        request: HttpServletRequest,
    ): String {
        // 모든 요청에 대하여 세션을 만드는 것이 아니라 세션을 사용할 때 생성을 함
        // 스프링에서는 세션 관리를 위하여 HttpSession 인터페이스를 제공, setAttribute / getAttribute 시 세션이 만들어 짐
        val session = request.getSession()
        session.setAttribute("SESSION_USER_KEY", "SESSION_USER_TEST_VALUE");

        return "Session Search !"
    }

    // SESSION 테스트 !
    @GetMapping("/user/session")
    fun getSession(
        request: HttpServletRequest,
    ): Any {
        val session = request.getSession()

        println("SESSION ATTRIBUTE NAME $session.attributeNames")

        val sessionAttributeNames = session.attributeNames

        sessionAttributeNames.toList().forEach {
            println("ALL SESSION NAMES $it")
        }

        return session.getAttribute("SESSION_USER_KEY")
    }
}
