package com.game;

public class Main {
  public static void main(String[] args) {
    Player p1 = new Player("baby", new Meanie());
    Player p2 = new Player("rude", new Meanie());
    Game prisoners = new Game(p1, p2);
    prisoners.start();


  }
}
