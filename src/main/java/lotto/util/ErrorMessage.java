package lotto.util;

public enum ErrorMessage {
  NOT_A_NUMBER("[ERROR] 숫자여야 합니다."),
  NOT_A_SINGLE_NUMBER("[ERROR] 보너스 번호는 하나의 숫자여야 합니다."),
  NOT_A_UNIT_OF_1000("[ERROR] 1000 단위의 금액이어야 합니다."),
  NOT_SIX_NUMBERS("[ERROR] 로또 번호는 총 6개여야 합니다."),
  NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
  MUST_NOT_DUPLICATE("[ERROR] 로또 번호는 중복이 없어야 합니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
