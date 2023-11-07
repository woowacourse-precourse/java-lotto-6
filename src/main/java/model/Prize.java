package model;

public enum Prize {

  FIRST(2000000000),
  SECOND(30000000),
  THIRD(1500000),
  FOURTH(50000),
  FIFTH(5000);

  final private int prize;

  Prize(int prize) {
    this.prize = prize;
  }

  Integer getPrize() {
    return prize;
  }

}
