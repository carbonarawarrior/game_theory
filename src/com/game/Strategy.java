package com.game;

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
    this.updateOppLastMove(true);
  }


  @Override
  public boolean makeDecision() {
    if (!this.getLastMove()) {
      return false;
    }  else if (this.getLastMove()) {
      return true;
    } else {
      return true;
    }
  }

}
class Naieve extends Strategy {

  @Override
  public boolean makeDecision() {
    return true;  
  }

}

class Meanie extends Strategy {

  @Override
  public boolean makeDecision() {
    return false;
  }

}
