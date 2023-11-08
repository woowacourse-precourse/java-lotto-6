package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.constants.ExceptionMessage;
import lotto.utils.constants.LottoNumConstant;

public class Validator {

    /**
     * Purchase amount validator
     */
    public static int purchaseAmountAndGet(String purchaseAmountStr) {
        isNumber(purchaseAmountStr);
        int purchaseAmount = Integer.parseInt(purchaseAmountStr);
        if (purchaseAmount < LottoNumConstant.LOTTO_AMOUNT_PURCHASE.getNumber()
            || purchaseAmount % LottoNumConstant.LOTTO_AMOUNT_PURCHASE.getNumber() != LottoNumConstant.ZERO.getNumber()
        ) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_SHOULD_BE_MULTIPLE_OF_THOUSAND.getMessage());
        }
        return purchaseAmount;
    }

    /**
     * Lotto number validator
     */
    public static List<Integer> lottoNumberAndGet(List<Integer> winningNumbers) {
        validateNumberListSize(winningNumbers);
        validateNoDuplicates(winningNumbers);
        validateNumberRange(winningNumbers);
        return winningNumbers;
    }

    private static void validateNumberListSize(List<Integer> numberStrings) {
        if (numberStrings.size() != LottoNumConstant.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_LIST_SIZE.getMessage());
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_HAS_DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (
            numbers.stream().anyMatch(num -> num < LottoNumConstant.LOTTO_MIN_NUM.getNumber()
                || num > LottoNumConstant.LOTTO_MAX_NUM.getNumber())
        ) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_IN_RANGE.getMessage());
        }
    }

    /**
     * Bonus number validator
     */
    public static int bonusNumberAndGet(String bonusNumberStr, Lotto winningNumbers) {
        isNumber(bonusNumberStr);
        int bonusNumber = Integer.parseInt(bonusNumberStr);
        if (
            bonusNumber < LottoNumConstant.LOTTO_MIN_NUM.getNumber()
                || bonusNumber > LottoNumConstant.LOTTO_MAX_NUM.getNumber()
        ) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_IN_RANGE.getMessage());
        }

        List<Integer> numbers = winningNumbers.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_LOTTO_NUM_DUPLICATED_BONUSNUM.getMessage());
        }
        return bonusNumber;
    }

    /**
     * Common validator
     */
    public static void isBlank(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_BLANK.getMessage());
        }
    }

    private static void isNumber(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_STRING_NOT_NUMBER.getMessage());
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() < numbers.size();
    }
}
