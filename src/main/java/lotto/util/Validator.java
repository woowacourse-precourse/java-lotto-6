package lotto.util;

import lotto.Lotto;
import lotto.LottoManager;
import lotto.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static void validateDigit(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }

    public static void validateAmountInThousands(int amount) throws IllegalArgumentException {
        int THOUSAND = 1000;
        if (amount % THOUSAND != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT);
        }
    }

    public static void validateOverZero(int amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_ZERO);
        }
    }

    public static void validateNumberOfLottoNumbers(List<Integer> lotto) throws IllegalArgumentException {
        if (lotto.size() != LottoManager.NUMBER_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_LOTTO_NUMBER_COUNT);
        }
    }

    public static void validateBonusNumberDuplicate(Lotto winningNumbers, int bonusNumber) throws IllegalArgumentException {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE);
        }
    }

    public static void validateLottoNumberDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRangeOfNumbers(Lotto winningNumbers) throws IllegalArgumentException {
        for (int number : winningNumbers.getNumbers()) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
            }
        }
    }

    public static void validateRangeOfNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        for (int number : winningNumbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
            }
        }
    }

    public static void validateRangeOfNumbers(Lotto winningNumbers, int bonusNumber) throws IllegalArgumentException {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
        }
        validateRangeOfNumbers(winningNumbers);
    }

    public static void validateRangeOfNumbers(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
        }
        validateRangeOfNumbers(winningNumbers);
    }
}
