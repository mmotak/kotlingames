package pl.mmotak.kik

class Game {
    private val board: Board
    private val xPlayer: Player
    private val oPlayer: Player

    private var currentPlayer: Player
    private var turn = 0

    init {
        board = Board()
        xPlayer = CPUPlayer('X')
        oPlayer = CPUPlayer('O')
        currentPlayer = oPlayer
    }

    fun isNotEnded(): Boolean {
        return !board.isFull()
    }

    fun drawBoard() {
        println("=======================")
        println("Turn: $turn")
        println("Player ${currentPlayer.type} please make move")
        board.draw()
    }

    fun currentPlayerMakeMove() {
        currentPlayer.makeMove(board)
    }

    fun drawEndMessage() {
        println("THE END")
        board.draw()
    }

    fun moveToNextPlayer() {
        currentPlayer = if (currentPlayer == xPlayer) oPlayer else xPlayer
        turn++
    }
}