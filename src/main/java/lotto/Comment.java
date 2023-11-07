package lotto;

public enum Comment {
  INPUT_PURCHASE_AMOUNT_COMMENT("구입금액을 입력해 주세요."),
  COUNT_PURCHASE_LOTTE_COMMENT("개를 구매했습니다."),
  INPUT_WINNING_NUMBERS_COMMENT("당첨 번호를 입력해 주세요."),
  INPUT_BONUS_NUMBER_COMMENT("보너스 번호를 입력해 주세요.");

  private final String comment;

  Comment(String comment) {
    this.comment = comment;
  }

  public String getComment() {
    return comment;
  }
}
