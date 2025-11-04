package com.game;

import java.util.HashMap;

public class Tournament {
  private HashMap<int, Player> playerList = new HaspMap<int, Player>();

  public Tournament() {

  }


  public addPlayer(String name, Strategy strat) {
    int id = playerList.size()++;
    Player p = new Player(name, id, strat);
  }
}
