package pl.mmotak.kik

abstract class Player(val type: Char) {
    fun makeMove(board: Board) {
        val place: Int = selectPlace()
        if (board.isPlaceEmpty(place)) {
            board.select(place, type)
        } else {
            makeMove(board)
        }
    }

    abstract fun selectPlace(): Int
}