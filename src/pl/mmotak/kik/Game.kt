package pl.mmotak.kik

class Game {
    private val board: Board
    private val xPlayer: Player
    private val oPlayer: Player

    private var currentPlayer: Player
    private var turn = 0

    init {
        board = Board()
        xPlayer = HumanPlayer('X')
        oPlayer = CPUPlayer('O')
        currentPlayer = oPlayer
    }

    fun isEnded(): Boolean {
        val playerWin = board.hasCurrentPlayerWin(currentPlayer.type)
        if (playerWin) {
            println("!!! Player ${currentPlayer.type} WIN in $turn")
            return true
        }
        return board.isFull()
    }

    fun drawBoard(drawBeforePlayerMove: Boolean = true) {
        if (drawBeforePlayerMove) {
            println("=======================")
            println("Turn: $turn")
            println("Player ${currentPlayer.type} please make move")
        } else {
            println("***********************")
        }
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