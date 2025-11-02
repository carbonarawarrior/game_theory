package com.game;

public class Game {
  private int rounds;
  private Player A;
  private Player B;

  public Game(int numRounds, Player p1, Player p2) {
    this.rounds = numRounds;
    this.A = p1;
    this.B = p2;
  }

  public Game(Player p1, Player p2) {
    this.rounds = 500;
    this.A = p1;
    this.B = p2;
  }

  /*
   *so if they both decide to coop they will get 3 points each
   *if one coops and the other betrays, the betrayer will get 5, the other 0
   *if they both betray they each get 1
   *
   */
  public void start() {
    boolean decisionA;
    boolean decisionB;
    for (int i = 0; i < rounds; i++) {

      //lets each strat make a decision for each rounds
      //determines winner each time
      
      decisionA = this.A.makeDecision();
      decisionB = this.B.makeDecision();

      if (decisionA && decisionB) {
        this.A.receivePoints(3);
        this.B.receivePoints(3);
      } else if (decisionA && !decisionB) {
        this.B.receivePoints(5);
        this.A.receivePoints(0);
      } else if (decisionB && !decisionA) {
        this.A.receivePoints(5);
        this.B.receivePoints(0);
      } else if (!decisionA && !decisionB) {
        this.A.receivePoints(1); 
        this.B.receivePoints(1);
      }

      //update the two players on the opponents decison
      this.A.updateOppLastMove(decisionB);
      this.B.updateOppLastMove(decisionA);


    }
    //this says who won or lost
    
    int pointsA = A.getPoints();
    int pointsB = B.getPoints();
    
    if (pointsA == pointsB) {
      System.out.println("Tie!");
    } else if (pointsA > pointsB) {
      System.out.println("A!");
    } else if (pointsB > pointsA) {
      System.out.println("B!");
    }
  }





}
