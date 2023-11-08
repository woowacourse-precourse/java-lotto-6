package lotto;

enum LottoPrizes {
  FirstPlace(2000000000, "6개 일치 (2,000,000,000원) - "),
  SecondPlace(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
  ThirdPlace(1500000, "5개 일치 (1,500,000원) - "),
  FourthPlace(50000, "4개 일치 (50,000원) - "),
  FifthPlace(5000, "3개 일치 (5,000원) - ");

  private final int prizeAmount;
  private final String prizeInfo;


  LottoPrizes(int prizeAmount, String prizeInfo) {
    this.prizeAmount = prizeAmount;
    this.prizeInfo = prizeInfo;
  }

  public int getPrizeAmount() {
    return this.prizeAmount;
  }

  public String getPrizeInfo() {
    return this.prizeInfo;
  }
}
