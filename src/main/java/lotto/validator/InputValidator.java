package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.common.message.ExceptionMessage;
import lotto.common.utils.NumberUtil;
import lotto.common.utils.RegexpUtil;
import lotto.domain.Lotto;

public class InputValidator {

  public static int validatePurchaseAmount(String input) {
    int amount = inputNumberCheck(input);
    inputPriceCheck(amount);
    return amount;
  }

  private static int inputNumberCheck(String input) {
    inputBlankCheck(input);
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ExceptionMessage.NON_NUMBER);
    }
  }

  private static void inputBlankCheck(String input) {
    if (input.isBlank()) {
      throw new IllegalArgumentException(ExceptionMessage.BLANK);
    }
  }

  private static void inputPriceCheck(int amount) {
    if (amount < NumberUtil.LOTTO_PRICE || amount % NumberUtil.LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_PRICE);
    }
  }

  private static void inputRangeCheck(int number) {
    if (number < NumberUtil.MIN_RANGE || number > NumberUtil.MAX_RANGE) {
      throw new IllegalArgumentException(ExceptionMessage.OVER_RANGE);
    }
  }

  private static void inputDuplicateCheck(int target, List<Integer> numbers) {
    if (numbers.contains(target)) {
      throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER);
    }
  }

  private static void inputCommaCheck(String input) {
    if (!input.matches(RegexpUtil.ONLY_NUMBER_AND_COMMA_CHECK)) {
      throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER);
    }
  }

  public static List<Integer> validateWinningNumbers(String input) {
    inputCommaCheck(input);
    List<Integer> result = Arrays.stream(input.split(","))
        .map(String::trim)
        .map(InputValidator::inputNumberCheck)
        .collect(Collectors.toList());
    Lotto.validate(result);
    return result;
  }

  public static int validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
    int bonus = inputNumberCheck(bonusNumber);
    inputRangeCheck(bonus);
    inputDuplicateCheck(bonus, winningNumbers);
    return bonus;
  }
}