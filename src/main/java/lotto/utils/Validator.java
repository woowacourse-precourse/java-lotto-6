package lotto.utils;

import static lotto.utils.Constant.LOTTO_SIZE;
import static lotto.utils.Constant.MAX_LOTTO;
import static lotto.utils.Constant.MIN_LOTTO;
import static lotto.utils.Constant.MIN_MONEY;

import java.util.List;
import lotto.exception.InvalidDivisionAmountException;
import lotto.exception.InvalidDuplicateLottoNumberException;
import lotto.exception.InvalidLottoNumberCountException;
import lotto.exception.InvalidLottoNumberRangeException;
import lotto.exception.InvalidMinimumAmountException;

public class Validator {
    public static void validateLottoSize(List<Integer> numbers) {
        if (hasValidSize(numbers, LOTTO_SIZE.getValue())) {
            return;
        }
        throw new InvalidLottoNumberCountException();
    }

    public static void validateLottoRange(int number) {
        if (isNumberInRange(number)) {
            return;
        }
        throw new InvalidLottoNumberRangeException();
    }

    public static void validateLottoDuplicates(List<Integer> numbers) {
        if (hasValidSize(numbers, numbers.size())) {
            return;
        }
        throw new InvalidDuplicateLottoNumberException();
    }

    public static void validateBonusDuplicates(List<Integer> numbers, int bonus) {
        if (isBonusNumberDistinct(numbers, bonus)) {
            return;
        }
        throw new InvalidDuplicateLottoNumberException();
    }

    public static void validateMinimumAmount(int money) {
        if (isAmountAboveMinimum(money)) {
            return;
        }
        throw new InvalidMinimumAmountException();
    }

    public static void validateDivisibleAmount(int money) {
        if (isAmountDivisible(money)) {
            return;
        }
        throw new InvalidDivisionAmountException();
    }

    private static boolean hasValidSize(List<Integer> numbers, int size) {
        return numbers.stream().distinct().count() == size;
    }

    private static boolean isBonusNumberDistinct(List<Integer> numbers, int bonus) {
        return !numbers.contains(bonus);
    }
    
    private static boolean isNumberInRange(int number) {
        return number >= MIN_LOTTO.getValue() && number <= MAX_LOTTO.getValue();
    }

    private static boolean isAmountAboveMinimum(int money) {
        return money >= MIN_MONEY.getValue();
    }

    private static boolean isAmountDivisible(int money) {
        return money % MIN_MONEY.getValue() == 0;
    }
}
