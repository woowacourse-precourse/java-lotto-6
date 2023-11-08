package lotto.exception;

public class InvalidRangeLottoNumberException extends IllegalArgumentException {

  private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45까지의 숫자만 가능합니다.";

  public InvalidRangeLottoNumberException() {
    super(ERROR_MESSAGE);
  }
}