package lotto.model;

import java.util.List;
import java.util.regex.Pattern;
import lotto.util.ErrorMessage;

public class BonusNumber {

    private static final Pattern bonusNumberInputPattern = Pattern.compile("\\d{1,2}");
    private int bonusNumber;

    public void inputBonusNumber(String input, List<Integer> winningNumbers) {
        validateBonusNumber(input);
        int number = Integer.parseInt(input);
        validateNumberRange(number);
        validateBonusNumber(winningNumbers, number);
        this.bonusNumber = number;
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateBonusNumber(String input) {
        if (!bonusNumberInputPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
