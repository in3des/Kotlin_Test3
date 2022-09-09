package jetbrains

import jetbrains.Gender.*

fun main(args: Array<String>) {
    val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE))

    println(heroes)
    println(heroes.last().name)
    println(heroes.firstOrNull { it.age == 30 }?.name)
    println(heroes.map { it.age }.distinct().size)
    println(heroes.filter { it.age < 30 }.size)

    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println(oldest.size)

    println(heroes.maxByOrNull { it.age }?.name)

    println(heroes.all { it.age < 50 })

    println(heroes.any { it.gender == FEMALE })

    val mapByAge: Map<Int, List<Hero>> =
        heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxByOrNull { (_, group) -> group.size }!!
    println(age)

    val mapByName: Map<String, Hero> =
        heroes.associateBy { it.name }
    println(mapByName["Frenchy"]?.age)

    val mapByName2 = heroes.associateBy { it.name }
    val unknownHero = Hero("Unknown", 0, null)
    println(mapByName2.getOrElse("unknown") { unknownHero }.age)

    val (first, second) = heroes
        .flatMap { heroes.map { hero -> it to hero } }
        .maxByOrNull { it.first.age - it.second.age }!!
    println( first.name )
}

data class Hero(val name: String, val age: Int, val gender: Gender?) {
}

enum class Gender { MALE, FEMALE }