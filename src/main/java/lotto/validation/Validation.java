package lotto.validation;

import java.util.HashSet;
import java.util.List;
import lotto.view.ErrorMessage;

public class Validation {
    private static final int LOTTO_PRISE = 1000;
    private static final int ZERO = 0;
    public static void checkIsDivideByThousand(final String input) {
        if (Integer.parseInt(input) % LOTTO_PRISE != 0) {
            ErrorMessage.isNotDivideByLottoAmount();
            throw new IllegalArgumentException();
        }
    }

    public static void checkIsNatural(final int input) {
        // checkIsNumber를 통과했기 때문에 0인지만 확인하면 된다.
        if (input == ZERO) {
            ErrorMessage.isNotNatural();
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoNumberLength(final int length, final List<Integer> lotto) {
        if (lotto.size() != length) {
            ErrorMessage.isNotMatchLottoLength();
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoNumberRange(final int start, final int end, final List<Integer> lotto) {
        for (Integer num : lotto) {
            checkNumberIsBetweenStartAndEnd(start, end, num);
        }
    }

    public static void checkNumberIsBetweenStartAndEnd(final int start, final int end, final int num) {
        if (num < start || num > end) {
            ErrorMessage.isNotInRange();
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicate(final List<Integer> lotto) {
        if (new HashSet<>(lotto).size() != lotto.size()) {
            ErrorMessage.isDuplicatedLotto();
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoNumbersHasBonusNumber(final List<Integer> lotto, final int bonus) {
        if (lotto.contains(bonus)) {
            ErrorMessage.lottoContainsBonusNumber();
            throw new IllegalArgumentException();
        }
    }

    public static void checkStringConsistOfNaturalNumbers(final String[] target) {
        for (String numbers : target) {
            checkIsNumber(numbers.trim());
        }
    }

    public static void checkIsNumber(final String numbers) {
        for (char c : numbers.toCharArray()) {
            if (!Character.isDigit(c)) {
                ErrorMessage.isNotNumber();
                throw new IllegalArgumentException();
            }
        }
    }
}
