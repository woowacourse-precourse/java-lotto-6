package lotto;

public enum Amount {
  THREE_MATCHES(5000),
  FOUR_MATCHES(50000),
  FIVE_MATCHES(1500000),
  FIVE_MATCHES_BONUS(30000000),
  SIX_MATCHES(2000000000);

  private final int amount;

  Amount(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }
}
