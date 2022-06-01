package entity

/**
 * @param resetPassCounter here we reset the passCounter to 0
 * @param incrementPassCounter we increase the amount of the passCounter by one
 * @param endGame to change the game mode from active to deactivated
 * @param goToNextTurn we change the Turn from the current Player to the next one in the Round
 */
class SchwimmenGame( var passCounter: Int=0, val gameLoop: Boolean,var gameActive:Boolean,var deckCards: Deck)
{

   var players:MutableList<SchwimmenPlayer> = mutableListOf()

   var currentPlayer:SchwimmenPlayer?= null


   lateinit var tableCards:MutableList<SchwimmenCard>;


   fun resetPassCounter(){
      passCounter=0;
   }




   fun incrementPassCounter(){
      passCounter++
   }

   fun endGame(){
      gameActive=false
   }

   fun goToNextTurn(){
      val indexOfCurrentPlayer=players.indexOf(currentPlayer)
      currentPlayer=players[(indexOfCurrentPlayer+1)%players.size]
   }

   fun addPlayer(player:SchwimmenPlayer){
      players.add(player)
   }




}


