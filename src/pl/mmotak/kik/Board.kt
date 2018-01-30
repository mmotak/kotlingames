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
}