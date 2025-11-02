package com.game;

public class Player {
  private String name;
  private int points;
  private boolean oppLastMove;
  private Strategy strat;

  public Player(String name, Strategy strat) {
    this.name = name;
    this.points = 0;
    this.strat = strat;
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
  }

  public boolean makeDecision() {
    return strat.makeDecision();
  }
}
