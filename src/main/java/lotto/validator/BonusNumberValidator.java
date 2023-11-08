package lotto.validator;

import static lotto.config.BonusNumberErrorMessage.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.config.BonusNumberErrorMessage.BONUS_NUMBER_UNIQUE_ERROR_MESSAGE;
import static lotto.config.InputPattern.BONUS_NUMBER_REGEX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.util.IntParser;

public class BonusNumberValidator implements Validator<String> {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile(BONUS_NUMBER_REGEX.getRegex());
    private final List<Integer> winningNumbers;

    public BonusNumberValidator(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public String validate(String input) {
        numeric(input);
        unique(winningNumbers, IntParser.parseInt(input));
        return input;
    }

    private void numeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private void unique(List<Integer> numbers, int bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (!uniqueNumbers.add(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_UNIQUE_ERROR_MESSAGE.getMessage());
        }
    }
}
