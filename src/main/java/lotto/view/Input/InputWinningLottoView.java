package lotto.view.Input;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidLottoInputTypeException;

public class InputWinningLottoView extends InputView {
  private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
  private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

  public List<Integer> getValue() {
    System.out.println(INPUT_MESSAGE);
    String result = inputValue();
    System.out.println();
    try {
      validate(result);
      return Stream.of(result.split(","))
              .map(Integer::parseInt)
              .collect(Collectors.toList());
    } catch (InvalidLottoInputTypeException | DuplicateLottoNumberException e) {
      System.out.println(e.getMessage());
      return getValue();
    }
  }

  private void validate(String inputValue) {
    validateInput(inputValue);
    validateDuplicate(inputValue);
  }

  private void validateInput(String inputValue) {
    if (!PATTERN.matcher(inputValue).matches()) {
      throw new InvalidLottoInputTypeException();
    }
  }

  private void validateDuplicate(String inputValue) {
    List<Integer> winningNumbers = Stream.of(inputValue.split(","))
            .map(Integer::parseInt)
            .toList();

    Set<Integer> uniqueNumbers = new HashSet<>();
    for (int number : winningNumbers) {
      if (uniqueNumbers.contains(number)) {
        throw new DuplicateLottoNumberException();
      }
      uniqueNumbers.add(number);
    }
  }
}