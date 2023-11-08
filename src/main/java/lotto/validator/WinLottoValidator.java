package lotto.validator;

import java.util.List;

public class WinLottoValidator {
    private static final int WINLOTTO_NUMBER_SIZE = 6;
    private static final int WINLOTTO_MIN_NUMBER = 1;
    private static final int WINLOTTO_MAX_NUMBER = 45;

    public static void validate(List<Integer> numbers, int bonus) {
        validateWinLottoNumbersSize(numbers);
        validateWinLottoNumbersAndBonusNumberDuplicate(numbers, bonus);
        validateWInLottoNumbersAndBonusNumberOutOfRange(numbers, bonus);
    }

    private static void validateWinLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != WINLOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateWinLottoNumbersAndBonusNumberDuplicate(List<Integer> numbers, int bonus) {
        if (ValidationUtil.isDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateWInLottoNumbersAndBonusNumberOutOfRange(List<Integer> numbers, int bonus) {
        for (Integer num : numbers) {
            if (ValidationUtil.isOutOfRange(WINLOTTO_MIN_NUMBER, WINLOTTO_MAX_NUMBER, num)) {
                throw new IllegalArgumentException();
            }
        }
        if (ValidationUtil.isOutOfRange(WINLOTTO_MIN_NUMBER, WINLOTTO_MAX_NUMBER, bonus)) {
            throw new IllegalArgumentException();
        }
    }
}