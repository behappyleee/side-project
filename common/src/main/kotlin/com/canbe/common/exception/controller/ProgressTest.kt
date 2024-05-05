package com.canbe.common.exception.controller

class ProgressTest {
}

fun main2() {
    val multiStr = "3".repeat(5)
    println(multiStr)

    val defaultProgressBar = "----------"
    val replaceProgress = defaultProgressBar.replaceRange(0, 10, "|")
    println(replaceProgress)

    val txt = "42 is the answer"
    val replaced = txt.replaceRange(0, 3, "|")
    println(replaced)


    val defaultStr = "----------"
    val replaceStr = defaultStr.replaceRange(0, 3, "|")
    println(replaceStr)

    var defaultStr1 = defaultStr.replaceRange(1 , 2, "|")
    println(defaultStr1)
}


fun main() {
    var progressBar = "----------"
    var progressPercent = "0%"
    println("[Progress Start]")
    println("Progress : [$progressBar] $progressPercent")
    // TODO
    // Refactoring 필요  .... !
    (1..10).forEach { index ->
        Thread.sleep(1000)
        val progressPercent = index * 10
        val progressingBarStatus = "|".repeat(index) + "-".repeat(progressBar.length - index)

        println("Progress : [$progressingBarStatus] $progressPercent%")
    }

    println("[Progress Complete]")
}

fun replaceStrByIndex(str: String): String {
    val progressingBar = "----------"
    return ""
}