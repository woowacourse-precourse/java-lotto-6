package lotto.exception;

import java.util.Collections;
import java.util.List;

public class Validator {
    public static final String LOTTO_NUMBERS_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않는 숫자 6개여야 합니다.";
    public static final String BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호와 중복되지 않은 1 ~ 45 사이의 숫자 1개여야 합니다.";
    public static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위의 숫자여야 합니다.";

    public static void isValidWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_ERROR_MESSAGE);
        }

        for (int number : numbers) {
            if (!isValidRange(number)) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_ERROR_MESSAGE);
            }

            if (isNumberDuplicated(number, numbers)) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_ERROR_MESSAGE);
            }
        }
    }

    public static void isValidBonusNumber(int number, List<Integer> numbers) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }

        if (isNumberContained(number, numbers)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void isValidAmount(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }

    public static boolean isValidRange(int number) {
        if (number < 1 || number > 45) {
            return false;
        }
        return true;
    }

    public static boolean isNumberContained(int number, List<Integer> numbers) {
        return numbers.contains(number);
    }

    public static boolean isNumberDuplicated(int number, List<Integer> numbers) {
        return Collections.frequency(numbers, number) > 1;
    }
}
