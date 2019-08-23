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
    val LOG = Logger.getLogger("Controller")

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        LOG.info("GET /greeting")
        runBlocking {
            val a = async { getUserDataFromServiceA() }
            val b = async { getUserDataFromServiceB() }
            val result = Result(a.await(), b.await())
            LOG.info (result.toString())
        }
        return "Hello, world"
    }

    suspend fun getUserDataFromServiceA():String {
        delay(1000L)
        LOG.info ("A is done after 1 second")
        return "this is A"
    }

    suspend fun getUserDataFromServiceB():String {
        delay(2000L)
        LOG.info ("B is done after 2 seconds")
        return "this is B"
    }

}

data class Result(val text1: String, val text2:String)
