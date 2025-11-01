package com.game;

abstract class Strategy {
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

    int deltaPoints;

    void updateDelta(int nd) {
      deltaPoints = nd;
    }

    abstract boolean makeDecision();

}

class Tit_For_Tat extends Strategy {
  public boolean makeDecision() {
    if (deltaPoints == 1) {
      return false;
    } else if (deltaPoints == 3) {
      return true;
    } else if (deltaPoints == 5) {
      return true;
    } else if (deltaPoints == 0) {
      return false;
    } else {
      return true;
    }
  }

}
class Naieve extends Strategy {
  public boolean makeDecision() {
    return true;  
  }

}

class Meanie extends Strategy {
  public boolean makeDecision() {
    return false;
  }

}
