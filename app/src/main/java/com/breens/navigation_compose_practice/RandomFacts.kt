package com.breens.navigation_compose_practice

fun generateRandomFact(): String {
    val randomFacts = listOf(
        "Competitive art used to be in the Olympics.",
        "A chef's hat has exactly 100 pleats.",
        "\"OMG\" usage can be traced back to 1917.",
        "Some cats are actually allergic to humans.",
        "The majority of your brain is fat.",
        "Oranges aren't naturally occurring fruits.",
        "Stop signs used to be yellow",
        "New York was briefly named \"New Orange.\"",
        "There was a successful Tinder match in Antarctica in 2014.",
        "There is a fruit that tastes like chocolate pudding.",
        "Too much water can kill you.",
        "The hottest temperature ever recorded on Earth was 2 billion degrees kelvin.",
        "The moon is (slowly) slowing the Earth's rotation.",
        "Dolphins have names for one another.",
        "The bowler hat was invented as safety measure.",
        "Sea otters hold hands while they sleep.",
        "Speed dating was invented by a rabbi.",
        "Parrots have the power of reason."
    )

    return randomFacts.random()
}