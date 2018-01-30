package pl.mmotak.kik

import java.util.*

class HumanPlayer(val t: Char) : Player(t) {
    val input = Scanner(System.`in`)

    override fun selectPlace(): Int {
        var userInput : Int
        do {
            println("Please select the number: ")
            userInput = input.nextInt()
        } while(userInput !in 1..9)
        return userInput
    }
}