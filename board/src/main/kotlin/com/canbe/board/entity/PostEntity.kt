package com.canbe.board.entity

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object PostEntity {
    // object 키워드는 싱글톤 생성 시 사용 - 클래스를 정의하면서 크 클래스의 단일 인스턴스를 만듦, 어플리케이션 내에서 공유되는 단일 인스턴스
    // object 는 객체 선언 (Object declaration) 을 나타내고
    // object: 는 객체 표현식을(Object Expression) 나타냄

    // 객체 표현식 object : object 키워드를 사용하여 클래스를 상속하거나 인터페이스를 구현하는 이름 없는 클래스 인스턴스를 만들 때 사용

    // kotlin 에서 companion 키워드는 클래스내에 정의 된 동반 객체를 지정할 때 사용 companion object 는 클래스의 인스턴스가 아니라 클래스 자체에 속함
    // 클래스 내의 정적 멤버와 유사한 역할을 함

    // TODO - Study 필요 Entity 와 Class 가 내부 적으로 어떻게 동작 하는 지 ... Study 가 필요 ... !
    object Posts : IntIdTable(name = "post") {
        val title: Column<String> = varchar(name = "title", length = 50)
        val content: Column<String> = varchar(name = "content", length = 500)
        val writer: Column<String> = varchar(name = "writer", length = 20)

        val createdAt: Column<LocalDateTime> =
            datetime("created_at").defaultExpression(CurrentDateTime)

        val updatedAt: Column<LocalDateTime> =
            datetime("updated_at").defaultExpression(CurrentDateTime)
    }

    class Post(id: EntityID<Int>) : IntEntity(id) {
        companion object : IntEntityClass<Post>(Posts)

        val postId = id.value
        val title by Posts.title
        val content by Posts.content
        val writer by Posts.writer
        val createdAt by Posts.createdAt
        val updatedAt by Posts.updatedAt
    }
}
