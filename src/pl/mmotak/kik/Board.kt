package pl.mmotak.kik

class Board {
    private val gameTable: MutableList<Char> = arrayListOf()

    companion object {
        const val MAGIC_VALUE_INT_TO_CHAR = 48
    }

    init {
        for (x in 1..9) {
            gameTable.add(x - 1, (x + MAGIC_VALUE_INT_TO_CHAR).toChar())
        }
    }

    private fun field(x: Int): String = "[${gameTable[x]}]"

    fun draw() {
        for (x in 0..8 step 3)
            println("${field(x)} ${field(x + 1)} ${field(x + 2)}")
    }

    fun isPlaceEmpty(place: Int): Boolean {
        return gameTable[place - 1] == (place + MAGIC_VALUE_INT_TO_CHAR).toChar()
    }

    fun select(place: Int, type: Char) {
        gameTable[place - 1] = type
    }

    fun isFull(): Boolean {
        for (x in 1..9) {
            if(gameTable[x - 1] == (x + MAGIC_VALUE_INT_TO_CHAR).toChar())
                return false
        }
        return true
    }
}