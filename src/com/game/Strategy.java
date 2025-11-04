package com.game;

import java.lang.Math;
//later I might try to refactor this to use functional programming to avoid goofiness
public abstract class Strategy {
   /*
    *So in this example there are only two decisions a Strategy can make
    *
    *co-operate
    *
    *or 
    *
    *betray
    *
    *ill have it so that when a Strategy chooses to co-operate it will
    *return true, otherwise false
    *
    */
    Strategy() {

    }

    private boolean oppLastMove;
    protected boolean isRandom; //may come in helpful for optimizations

    public void updateOppLastMove(boolean lastMove) {
      this.oppLastMove = lastMove;
    }

    protected boolean getLastMove() {
      return oppLastMove;
    }

    public abstract boolean makeDecision();

}

class Tit_For_Tat extends Strategy {
  public Tit_For_Tat() {
    //this is so that tit for tat trusts first
    this.updateOppLastMove(true);
    this.isRandom = false;
  }


  @Override
  public boolean makeDecision() {
    return this.getLastMove();
  }

}
class Naieve extends Strategy {

  public Naieve() {
    this.isRandom = false;
  }

  @Override
  public boolean makeDecision() {
    return true;  
  }

}

class Meanie extends Strategy {

  public Meanie() {
    this.isRandom = false;
  }
  @Override
  public boolean makeDecision() {
    return false;
  }

}

class Tit_For_Two_Tats extends Strategy {
  public Tit_For_Two_Tats() {
    //this is so that tit for two tats trusts first
    this.pastTwoDecisions[0] = true;
    this.pastTwoDecisions[1] = true;
    this.isRandom = false;
  }

  private boolean[] pastTwoDecisions = new boolean[2];
  @Override
  public void updateOppLastMove(boolean lastMove) {
    this.pastTwoDecisions[0] = this.pastTwoDecisions[1];
    this.pastTwoDecisions[1] = lastMove;
  }

  @Override
  public boolean makeDecision() {
    if (this.pastTwoDecisions[0] == false && this.pastTwoDecisions[1] == false) {
      return false;
    }
    return true;
  }

}

class Random extends Strategy {

  public Random() {
    this.updateOppLastMove(this.makeDecision());
    this.isRandom = true;
  }

  @Override
  public boolean makeDecision() { 
    int result = (int) (Math.random() * 2);

    if (result == 1) {
      return true;
    }

    if (result == 0) {
      return false;
    }

    return true;//should never happern
  }
}
