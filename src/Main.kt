import pl.mmotak.kik.Game

fun main(args: Array<String>) {
    val game = Game()
    while(game.isNotEnded()) {
        game.moveToNextPlayer()
        game.drawBoard()
        game.currentPlayerMakeMove()
    }

    game.drawEndMessage()
}