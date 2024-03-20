package com.canbe.board.controller

import com.canbe.board.dto.PostDto
import com.canbe.board.util.ApiVersion
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiVersion.JPA_FIRST_VERSION_API_PATH + "/posts")
class PostJpaController {

    @GetMapping
    fun findAllPosts(): List<PostDto>? {




        return null
    }

}