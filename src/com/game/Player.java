package com.game;

public class Player {
  private int points;
  private boolean oppLastMove;
  private Strategy strat;

  //here are cross-game stats, to be only updated through tournaments
  private String name;
  private int wins;
  private int total_points;

  public Player(String name, Strategy strat) {
    this.name = name;
    this.points = 0;
    this.strat = strat;
    this.wins = 0;
    this.total_points = 0;
  }

  //resets all temporary vars, is just points for now
  public void reset() {
    this.points = 0;
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
    total_points += numPoints;
  }

  public int getWins() {
    return this.wins;
  }

  public void giveWin() {
    this.wins++;
  }

  public boolean makeDecision() {
    return strat.makeDecision();
  }
}
