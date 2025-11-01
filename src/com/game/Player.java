package com.game;

public class Player {
  private String name;
  private int points;
  private int deltaPoints;
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

  public void recievePoints(int numPoints) {
    points += numPoints;
    deltaPoints = numPoints;
  }

  public boolean makeDecision() {
    strat.updateDelta(deltaPoints);
    return strat.makeDecision();
  }
}
