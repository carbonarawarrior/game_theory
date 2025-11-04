package com.game;

public class Player {
  private int points;
  private boolean oppLastMove;
  private Strategy strat;

  //here are cross-game stats, to be only updated through tournaments
  private String name;
  private int wins;
  private int numGames;
  private int totalPoints;
  private double averagePoints;

  public Player(String name, Strategy strat) {
    this.name = name;
    this.points = 0;
    this.strat = strat;
    this.wins = 0;
    this.totalPoints = 0;
  }


  public int getPoints() {
    return this.points;
  }

  public String getName() {
    return this.name;
  }

  public void updateOppLastMove(boolean decision) {
    this.oppLastMove = decision;
    this.strat.updateOppLastMove(decision);
  }
  

  public void receivePoints(int numPoints) {
    points += numPoints;
    totalPoints += numPoints;
  }

  public int getWins() {
    return this.wins;
  }

  public void endGame(boolean win) {
    if (win) {
      this.wins++;
    }

    this.numGames++;
    this.averagePoints = (double) this.totalPoints/this.numGames;

    this.points = 0;
  }

  public boolean makeDecision() {
    return strat.makeDecision();
  }
}
