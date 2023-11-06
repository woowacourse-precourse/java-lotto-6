package lotto;

import java.util.Arrays;

public enum Rank {
  FIRST(2000000000, "6"),
  SECOND(30000000, "5+1"),
  THIRD(1500000, "5"),
  FORTH(50000, "4"),
  FIFTH(5000, "3");

  private final int price;
  private final String winningNumberCount;

  Rank(int price, String winningNumberCount) {
    this.price = price;
    this.winningNumberCount = winningNumberCount;
  }

  public int getPrice() {
    return this.price;
  }

  public String getWinningNumbers() {
    return this.winningNumberCount;
  }

  public static Rank valueOfLabel(String winningNumberCount) {
    return Arrays.stream(values())
        .filter(value -> value.winningNumberCount.equals(winningNumberCount))
        .findAny()
        .orElse(null);
  }
}
