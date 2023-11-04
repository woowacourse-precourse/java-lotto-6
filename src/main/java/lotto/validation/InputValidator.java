package lotto.validation;

import java.util.regex.Pattern;

public class InputValidator {

  private static final String INPUT_BLANK_MESSAGE = "입력은 공백일 수 없습니다.";
  private static final String INPUT_EMPTY_MESSAGE = "입력은 비어있을 수 없습니다.";

  private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

  public void basicValidation(String input) {
    validateInputEmpty(input);
    validateInputBlank(input);
    validateInputNumeric(input);
  }

  private void validateInputEmpty(String input) {
    if (isEmpty(input)) {
      throw new IllegalArgumentException(INPUT_EMPTY_MESSAGE);
    }
  }

  private void validateInputBlank(String input) {
    if (isBlank(input)) {
      throw new IllegalArgumentException(INPUT_BLANK_MESSAGE);
    }
  }

  private void validateInputNumeric(String input) {
    if (isMatchNumber(input)) {
      throw new NumberFormatException();
    }
  }

  private boolean isEmpty(String input) {
    return input.isEmpty();
  }

  private boolean isBlank(String input) {
    return input.isBlank();
  }

  private boolean isMatchNumber(String input) {
    return !ONLY_NUMBER_PATTERN.matcher(input).matches();
  }

}
