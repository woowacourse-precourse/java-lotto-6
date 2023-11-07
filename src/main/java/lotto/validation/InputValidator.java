package lotto.validation;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidator {

  private static final String INPUT_BLANK_MESSAGE = "입력은 공백일 수 없습니다.";
  private static final String INPUT_EMPTY_MESSAGE = "입력은 비어있을 수 없습니다.";
  private static final String INPUT_NUMERIC_MESSAGE = "숫자만 입력할 수 있습니다.";

  private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

  public void validateInputEmpty(String input) {
    if (isEmpty(input)) {
      throw new IllegalArgumentException(INPUT_EMPTY_MESSAGE);
    }
  }

  public void validateInputBlank(String input) {
    if (isBlank(input)) {
      throw new IllegalArgumentException(INPUT_BLANK_MESSAGE);
    }
  }

  public void validateInputNumeric(String input) {
    if (isMatchNumber(input)) {
      throw new IllegalArgumentException(INPUT_NUMERIC_MESSAGE);
    }
  }

  public void validateNumbersNumeric(String[] inputNumbers) {
    if (isMatchNumbers(inputNumbers)) {
      throw new IllegalArgumentException(INPUT_NUMERIC_MESSAGE);
    }
  }

  private boolean isMatchNumbers(String[] inputNumbers) {
    return Arrays.stream(inputNumbers).allMatch(this::isMatchNumber);
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
