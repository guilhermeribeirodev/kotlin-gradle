package com.base.customer

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import kotlin.test.assertEquals

class TestSource {
    @Test fun f() {
        val items = listOf(1, 2, 3, 4, 5)

// Lambdas are code blocks enclosed in curly braces.
        items.fold(0, {
            // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val result = acc + i * i
            println("result = $result")
            // The last expression in a lambda is considered the return value:
            result
        })

// Parameter types in a lambda are optional if they can be inferred:
        val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

// Function references can also be used for higher-order function calls:
        val product = items.fold(1, Int::times)
    }

    @Test fun f1() {
        assertEquals("Hello, world!", getGreeting())
        assertThat(getGreeting(), `is`("Hello, world!"))
    }



    private fun getGreeting(): String {
        return "Hello, world!"
    }

    fun <T, R> Collection<T>.fold(
            initial: R,
            combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }
}