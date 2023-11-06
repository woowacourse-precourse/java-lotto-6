package lotto.model;

public enum WinningMoney {
  NON_MATCH(0, false, 0),
  THREE_MATCH(3, false, 5000),
  FOUR_MATCH(4, false, 50000),
  FIVE_MATCH(5, false,1500000),
  FIVE_MATCH_BONUS(5,true, 30000000),
  SIX_MATCH(6, false, 2000000000);

  private int correctCount;
  private boolean hasBonus;
  private int price;

  WinningMoney(int correctCount, boolean hasBonus, int price) {
    this.correctCount = correctCount;
    this.hasBonus = hasBonus;
    this.price = price;
  }
}
