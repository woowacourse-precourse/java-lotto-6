package lotto.exception;

public class NumberTypeException extends IllegalArgumentException {

  private static final String ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

  public NumberTypeException() {
    super(ERROR_MESSAGE);
  }
}