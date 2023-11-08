package lotto.utils;

public enum GuideMessage {
  INPUT_AMOUNT("구입금액을 입력해 주세요."),
  INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
  INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
  private final String message;

  GuideMessage(String s) {
    this.message = s;
  }

  public String getMessage() {
    return message;
  }
}
