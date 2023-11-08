package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoExceptionType;
import lotto.exception.LottoValidateException;

public class LottoValidate {

    public static void validateLottoNumbers(List<Integer> numbers) {

        if (hasDuplicates(numbers)) {
            throw new LottoValidateException(LottoExceptionType.DUPLICATE_NUMBERS.getMessage());
        }
        boolean allNumbersValid = numbers.stream().allMatch(LottoValidate::isNumberWithinLottoRange);

        if (!allNumbersValid) {
            throw new LottoValidateException(LottoExceptionType.INVALID_NUMBER_RANGE.getMessage());
        }

    }


    public static void validateLottonMoney(int money) {
        if (money < LottoNumberConstants.LOTTO_PRICE.getValue()) {
            throw new LottoValidateException(LottoExceptionType.MINIMUM_LOTTO_AMOUNT.getMessage());
        }

        if (money % LottoNumberConstants.LOTTO_PRICE.getValue() != LottoNumberConstants.NO_REMAINDER.getValue()) {
            throw new LottoValidateException(LottoExceptionType.MULTIPLE_OF_1000.getMessage());
        }
    }

    public static void validateBonusNumber(int input) {
        if (input < LottoNumberConstants.MIN_LOTTO_NUMBER.getValue() || input > LottoNumberConstants.MAX_LOTTO_NUMBER.getValue()) {
            throw new LottoValidateException(LottoExceptionType.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private static boolean isNumberWithinLottoRange(int number) {
        return number >= LottoNumberConstants.MIN_LOTTO_NUMBER.getValue()
                && number <= LottoNumberConstants.MAX_LOTTO_NUMBER.getValue();
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
