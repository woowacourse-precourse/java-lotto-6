package lotto.exception;

public class InvalidLottoInputTypeException extends IllegalArgumentException {

  private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자만 가능합니다.";

  public InvalidLottoInputTypeException() {
    super(ERROR_MESSAGE);
  }
}