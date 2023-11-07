package lotto;

public enum StatisticsComment {
  THREE_MATCHES("3개 일치 (5,000원) - "),
  FOUR_MATCHES("4개 일치 (50,000원) - "),
  FIVE_MATCHES("5개 일치 (1,500,000원) - "),
  FIVE_MATCHES_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
  SIX_MATCHES("6개 일치 (2,000,000,000원) - ");

  private final String comment;

  StatisticsComment(String comment) {
    this.comment = comment;

  }

  public String getComment() {
    return comment;
  }
}
