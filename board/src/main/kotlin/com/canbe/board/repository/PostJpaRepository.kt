package com.canbe.board.repository

import com.canbe.board.dto.JpaPostDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PostJpaRepository : JpaRepository<JpaPostDto, Int>