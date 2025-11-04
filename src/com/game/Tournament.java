package com.game;

import java.util.ArrayList;

public class Tournament {
  private ArrayList<Player> playerList;

  private Player[] highestTotalPoints;
  private Player[] highestAveragePoints;
  private Player[] mostWins;

  public Tournament() {
    this.playerList = new ArrayList<Player>();

    this.highestTotalPoints = new Player[10];
    this.highestAveragePoints = new Player[10];
    this.mostWins = new Player[10];
  }

  private void updateBoards() {


  }


  public void addPlayer(String name, Strategy strat) {
    Player p = new Player(name, strat);
    this.playerList.add(p);
  }

  public void addPlayer(Player p) {
    this.playerList.add(p);
  }
  

  public Player getPlayer(int index) {
    return playerList.get(index);
  }

  public void runAllGames() {
    Game currentGame;
    for (int i = 0; i < playerList.size(); i++) {
      for (int j = i + 1; j < playerList.size(); j++) {
        currentGame = new Game(this.getPlayer(i), this.getPlayer(j));
        currentGame.start();
      }
    }
  }
}
