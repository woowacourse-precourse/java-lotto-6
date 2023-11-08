package lotto.view.Input;

import java.util.regex.Pattern;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.NumberTypeException;

public class InputBonusNumberView extends InputView {
  private static final Pattern PATTERN = Pattern.compile("\\d+");
  private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

  public Integer getValue() {
    System.out.println(INPUT_MESSAGE);
    String result = inputValue();
    System.out.println();
    try {
      validate(result);
      return Integer.parseInt(result);
    } catch (NumberTypeException | DuplicateLottoNumberException e) {
      System.out.println(e.getMessage());
      return getValue();
    }
  }

  private void validate(String inputValue) {
    validateFormat(inputValue);
  }

  private void validateFormat(String inputValue) {
    if (!PATTERN.matcher(inputValue).matches()) {
      throw new NumberTypeException();
    }
  }
}