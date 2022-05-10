package service

import entity.*

class PlayerActionService (private val rootService: RootService): AbstractRefreshingService(){

    fun knock(player: SchwimmenPlayer){
        val game=rootService.currentGame
        checkNotNull(game)
        knock(player)
    }
    fun changeOneCard(handCard:SchwimmenCard,tableCard:SchwimmenCard){
        val game=rootService.currentGame
        checkNotNull(game)
        changeOneCard(handCard, tableCard)
        onAllRefreshables{refreshAfterTurn()}

    }
    fun changeAllCards(){
        val game= rootService.currentGame
        checkNotNull(game)
        var temp = game.currentPlayer?.dealtHandCards
        game.currentPlayer?.dealtHandCards=game.tableCards
        if (temp != null) {
            game.tableCards = temp
        }
        onAllRefreshables{refreshAfterTurn()}

    }
    fun pass(){
        val game=rootService.currentGame
        checkNotNull(game)
        if(game.passCounter== game.Players.size){
            if(game.cards.size>=3){
                game.tableCards=game.extractThreeCards()
                game.passCounter=0
                onAllRefreshables{refreshAfterTurn()}
            }
            else{
                GameService.endGame()
            }
        }
    }
}