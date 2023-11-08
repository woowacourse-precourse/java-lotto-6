package lotto.exception;

public class EnterLottoMoneyFormatException extends IllegalArgumentException {

  private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위의 금액을 입력해야 합니다..";

  public EnterLottoMoneyFormatException() {
    super(ERROR_MESSAGE);
  }
}