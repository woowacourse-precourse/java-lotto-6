package lotto.util;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isValidWinningNumbers(List<LottoNumber> input) {
        if(isEmptyInput(input)) return false;
        if(isInvalidNameLength(input)) return false;
        if(hasDuplicateLottoNumber(input)) return false;
        return true;
    }

    public static boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        return numericPattern.matcher(input).matches();
    }

    private static boolean isEmptyInput(final List<LottoNumber> input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isInvalidNameLength(final List<LottoNumber> input) {
        if(input.size() != LOTTO_NUMBERS_SIZE) return true;
        return false;
    }

    public static boolean hasDuplicateLottoNumber(List<LottoNumber> numbers) {
        if(Set.copyOf(numbers).size() == numbers.size()) {
            return false;
        }
        return true;
    }
}
