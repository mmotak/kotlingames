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
            if (gameTable[x - 1] == (x + MAGIC_VALUE_INT_TO_CHAR).toChar())
                return false
        }
        return true
    }

    fun hasCurrentPlayerWin(type: Char): Boolean {
//        [1] [2] [3]
//        [4] [5] [6]
//        [7] [8] [9]
        return crossWin(type) || lineWin(type)
    }

    private fun createArray(a: Int, b: Int, c: Int) = arrayOf(gameTable[a - 1], gameTable[b - 1], gameTable[c - 1])

    private fun lineWin(type: Char): Boolean {
        // horizontal
        return testLine(type, arrayOf(1, 2, 3))
                || testLine(type, arrayOf(4, 5, 6))
                || testLine(type, arrayOf(7, 8, 9))
                // vertical
                || testLine(type, arrayOf(1, 4, 7))
                || testLine(type, arrayOf(2, 5, 8))
                || testLine(type, arrayOf(3, 6, 9))
    }

    private fun crossWin(type: Char): Boolean {
        return testLine(type, arrayOf(1, 5, 9))
                || testLine(type, arrayOf(7, 5, 3))
    }

    private fun testLine(type: Char, items: Array<Int>): Boolean {
        val isWinRow = createArray(items[0], items[1], items[2]).all { it == type }
        if (isWinRow) {
            print("Win row: ")
            items.forEach { print("$it ") }
            print("\n")
        }
        return isWinRow
    }
}