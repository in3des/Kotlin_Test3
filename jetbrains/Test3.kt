package jetbrains

fun main(args: Array<String>) {
    val s = "123"
    println(s as? Int)    // null
    println(s as Int?)    // exception
}