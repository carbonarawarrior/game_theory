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

    private int deltaPoints;

    public void updateDelta(int nd) {
      this.deltaPoints = nd;
    }

    protected int getDelta() {
      return deltaPoints;
    }

    public abstract boolean makeDecision();

}

class Tit_For_Tat extends Strategy {
  public Tit_For_Tat() {
    this.updateDelta(5);
  }


  @Override
  public boolean makeDecision() {
    if (this.getDelta() == 1) {
      return false;
    } else if (this.getDelta() == 3) {
      return true;
    } else if (this.getDelta() == 5) {
      return true;
    } else if (this.getDelta() == 0) {
      return false;
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
