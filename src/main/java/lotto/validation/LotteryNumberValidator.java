package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.LotteryPolicy;

public class LotteryNumberValidator extends LotteryPolicy {

  public static void validateLottoSize(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException();
    }
  }

  public static void checkDuplicate(List<Integer> numbers) {
    Set<Integer> uniqueNumbers = new HashSet<>();
    numbers.stream()
        .filter(number -> !uniqueNumbers.add(number))
        .findFirst()
        .ifPresent(duplicate -> {
          throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        });
  }

  public static void validateNumberRange(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
    }
  }

  public static void validatePurchaseAmountDivisibility(int purchaseAmount) {
    if (purchaseAmount % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_ERROR_MESSAGE);
    }
  }

  public static void validateNumberFormat(String number) {
    try {
      Integer.parseInt(number);
    } catch (Exception e) {
      throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT_ERROR_MESSAGE);
    }
  }

  public static void validateNumberOfToken(int number) {
    if (number != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException(INVALID_TOKEN_ERROR_MESSAGE);
    }
  }
}
