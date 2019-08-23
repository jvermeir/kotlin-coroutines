package com.example.demo

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@RestController
class Controller {

    val counter = AtomicLong()
    val LOG = Logger.getLogger("Greetinglogger")

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        runBlocking {
            val a = async { getUserDataFromServiceA() }
            val b = async { getUserDataFromServiceB() }
            println("a: " + a.await() + "\nb: " + b.await())
        }
        return "Hello, world"
    }

    suspend fun getUserDataFromServiceA():String {
        delay(1000L)
        println ("A is done")
        return "dit is A"
    }

    suspend fun getUserDataFromServiceB():String {
        delay(2000L)
        println ("B is done")
        return "dit is B"
    }



}

