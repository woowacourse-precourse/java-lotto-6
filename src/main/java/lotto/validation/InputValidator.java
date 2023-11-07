package lotto.validation;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.exception.ErrorType;

public class InputValidator {

  private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

  public void validateInputEmpty(String input) {
    if (isEmpty(input)) {
      throw new IllegalArgumentException(ErrorType.INPUT_NOT_EMPTY.getMessage());
    }
  }

  public void validateInputBlank(String input) {
    if (isBlank(input)) {
      throw new IllegalArgumentException(ErrorType.INPUT_NOT_BLANK.getMessage());
    }
  }

  public void validateInputNumeric(String input) {
    if (isMatchNumber(input)) {
      throw new NumberFormatException(ErrorType.INPUT_NOT_NUMERIC.getMessage());
    }
  }

  public void validateMatchNumbers(String[] inputNumbers) {
    Arrays.stream(inputNumbers).allMatch(this::isMatchNumber);
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
