package lotto.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.InputLottoWinningNumbersValidator;
import lotto.validator.LottoWinningNumberValidator;
import lotto.validator.LottoWinningNumbersValidator;
import lotto.view.InputView;

public class InputProcessor {
    private static final int LOTTO_PRICE = 1000;

  public static int calculateLottoCount(int money) {
      return money / LOTTO_PRICE;
    }

  public static List<String> splitWinningNumbers(String input) {
    String[] numberStrings = input.split(",");
    List<String> WinningNumbers = Arrays.asList(numberStrings);
    try {
      LottoWinningNumbersValidator.isNoDuplicateLottoNumbers(WinningNumbers);
      LottoWinningNumbersValidator.isLottoNumbersLengthValid(WinningNumbers);
      InputLottoWinningNumbersValidator.isEmptyString(WinningNumbers);
      LottoWinningNumberValidator.isAllIntegersValid(WinningNumbers);
      LottoWinningNumberValidator.isValueInRange(WinningNumbers);
      return WinningNumbers;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return splitWinningNumbers(InputView.inputWinningNumber());
    }
  }

  public static List<Integer> convertToIntegerList(List<String> numberStrings) {
    return numberStrings.stream()
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

}

