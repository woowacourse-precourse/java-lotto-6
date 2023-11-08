package lotto.validate;

import static lotto.util.ErrorMessage.NO_BLANK;
import static lotto.util.ErrorMessage.NO_DUPLICATE;
import static lotto.util.ErrorMessage.ONLY_1_45_NUMBER;
import static lotto.util.ErrorMessage.ONLY_DIVIDED_COMMA_NUMBERS;
import static lotto.util.ErrorMessage.ONLY_DIVIDED_THOUSAND_NUMBER;

import java.util.List;
import java.util.Objects;
import lotto.view.InputParser;

public class InputValidation {
    public static final int  THOUSAND = 1000;
    private static final int  ZERO = 0;
    private static final String LOTTO_NUMBER_REG_EXP = "^(?:45|[1-4]?[0-9])(?:,(?:45|[1-4]?[0-9]))*$";
    private static final String NUMBER_REG_EXP = "^[0-9]+$";


    public void validateWinningNumbers(String numbers) {
        isNullOrBlank(numbers);
        isLottoNumberOnly(numbers);
        isNumbersDivied6NumbersWithComma(numbers);
        isDuplicate(InputParser.parseInputWinningNumners(numbers));
    }

    public void validateBonusNumber(String bonus, String winningNumber) {
        isNullOrBlank(bonus);
        isLottoNumberOnly(bonus);
        validateDuplicate(bonus, winningNumber);
    }

    public void isLottoNumberOnly(String number) {
        if (!number.matches(LOTTO_NUMBER_REG_EXP)) {
            throw new IllegalArgumentException(ONLY_1_45_NUMBER);
        }
    }
    public void isNumberOnly(String number) {
        if (!number.matches(NUMBER_REG_EXP)) {
            throw new IllegalArgumentException(ONLY_DIVIDED_THOUSAND_NUMBER);
        }
    }
    public void isDividedOneThousand(int number) {
        if (number % THOUSAND != ZERO) {
            throw new IllegalArgumentException(ONLY_DIVIDED_THOUSAND_NUMBER);
        }
    }
    public void isNullOrBlank(String number) {
        if (Objects.isNull(number) || number.isBlank() || numberWhiteSpace(number)) {
            throw new IllegalArgumentException(NO_BLANK);
        }
    }

    public boolean numberWhiteSpace(String number) {
        return !number.replaceAll("\\s","").equals(number);
    }

    public void isNumbersDivied6NumbersWithComma(String numbers) {
        if (numbers.split(",").length != 6) {
            throw new IllegalArgumentException(ONLY_DIVIDED_COMMA_NUMBERS);
        }
    }
    public static void isDuplicate(List<Integer> numbers) {
        if (duplicateCount(numbers) < numbers.size()) {
            throw new IllegalArgumentException(NO_DUPLICATE);
        }
    }

    public static int duplicateCount(List<Integer> numbers) {
        return (int)numbers.stream().distinct().count();
    }

    public void validateDuplicate(String bonus, String winningNumber) {
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException(NO_DUPLICATE);
        }
    }
}
