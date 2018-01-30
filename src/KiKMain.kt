import pl.mmotak.kik.Game

fun main(args: Array<String>) {
    val game = Game()
    while(!game.isEnded()) {
        game.moveToNextPlayer()
        game.drawBoard(true)
        game.currentPlayerMakeMove()
        game.drawBoard(false)
    }

    game.drawEndMessage()
}