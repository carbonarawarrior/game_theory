package com.game;

public class Game {
  private int rounds;
  private Player A;
  private Player B;

  //weights
  private int doubleWinReward;
  private int betrayWinReward;
  private int betrayLosePenalty;
  private int doubleLosePenalty;
  
  public Game(int numRounds, Player p1, Player p2, int dwr, int bwr, int blp, int dlp) {
    this.rounds = numRounds;
    this.A = p1;
    this.B = p2;
    
    this.doubleWinReward = dwr;
    this.betrayWinReward = bwr;
    this.betrayLosePenalty = blp;
    this.betrayLosePenalty = dlp;
  }


  public Game(int numRounds, Player p1, Player p2) {
    this.rounds = numRounds;
    this.A = p1;
    this.B = p2;
    
    this.doubleWinReward = 3;
    this.betrayWinReward = 5;
    this.betrayLosePenalty = 0;
    this.betrayLosePenalty = 1;

  }

  //default constructor
  public Game(Player p1, Player p2) {
    this.rounds = 500;
    this.A = p1;
    this.B = p2;

    this.doubleWinReward = 3;
    this.betrayWinReward = 5;
    this.betrayLosePenalty = 0;
    this.betrayLosePenalty = 1;
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
        this.A.receivePoints(this.doubleWinReward);
        this.B.receivePoints(this.doubleWinReward);
      } else if (decisionA && !decisionB) {
        this.B.receivePoints(this.betrayWinReward);
        this.A.receivePoints(this.betrayLosePenalty);
      } else if (decisionB && !decisionA) {
        this.A.receivePoints(this.betrayWinReward);
        this.B.receivePoints(this.betrayLosePenalty);
      } else if (!decisionA && !decisionB) {
        this.A.receivePoints(this.doubleLosePenalty); 
        this.B.receivePoints(this.doubleLosePenalty);
      }

      //update the two players on the opponents decison
      this.A.updateOppLastMove(decisionB);
      this.B.updateOppLastMove(decisionA);


    }
    //this says who won or lost
    
    int pointsA = A.getPoints();
    int pointsB = B.getPoints();
    
    if (pointsA > pointsB) {
      this.A.giveWin();
    } else if (pointsB > pointsA) {
      this.B.giveWin();
    }
  }





}
