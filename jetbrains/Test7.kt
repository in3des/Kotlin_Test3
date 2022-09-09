package jetbrains

import kotlin.random.Random

val foo: Int
    get() = (0..100).random()

fun main(args: Array<String>) {
    // The values should be different:
    println(foo)
    println(foo)
    println(foo)
}