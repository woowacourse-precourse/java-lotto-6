package lotto.domain;

public class RateOfReturn {
  private final double rate;

  public RateOfReturn(Money price, PrizeResult prizeResult) {
    this.rate = (getAllPrice(prizeResult) * 0.1) / price.getTicket();
  }

  private long getAllPrice(PrizeResult prizeResult) {
    int result = 0;

    for (Prize prize : Prize.values()) {
      result += prizeResult.getPrizeCount(prize) * prize.getMoney();
    }

    return result;
  }

  public double getRate() {
    return rate;
  }
}