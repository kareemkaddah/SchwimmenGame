package entity

class SchwimmenGame(var passCounter: Int=0, val gameLoop: Boolean,var gameActive:Boolean,var deckCards: Deck)
{

   var players:MutableList<SchwimmenPlayer> = mutableListOf()

   var currentPlayer:SchwimmenPlayer?= null


   lateinit var tableCards:MutableList<SchwimmenCard>;


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