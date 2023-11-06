package lotto.validator;

import static lotto.config.InputPattern.WINNING_LOTTO_COMMA_REGEX;
import static lotto.config.InputPattern.WINNING_LOTTO_NUMERIC_REGEX;
import static lotto.config.WinningLottoErrorMessage.WINNING_LOTTO_COMMA_ERROR_MESSAEGE;
import static lotto.config.WinningLottoErrorMessage.WINNING_LOTTO_NUMERIC_ERROR_MESSAGE;
import static lotto.config.WinningLottoErrorMessage.WINNING_LOTTO_UNIQUE_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.util.NumberSplitter;

public class WinningLottoValidator implements Validator <String> {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile(WINNING_LOTTO_NUMERIC_REGEX.getRegex());
    private static final Pattern COMMA_PATTERN = Pattern.compile(WINNING_LOTTO_COMMA_REGEX.getRegex());

    @Override
    public String validate(String input) {
        comma(input);
        numericWithComma(input);
        unique(NumberSplitter.splitNumbers(input));
        return input;
    }

    private void numericWithComma(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(WINNING_LOTTO_NUMERIC_ERROR_MESSAGE.getMessage());
        }
    }

    private void comma(String input) {
        if (!COMMA_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(WINNING_LOTTO_COMMA_ERROR_MESSAEGE.getMessage());
        }
    }

    private void unique(List<String> splitNumbers) {
        Set<String> uniqueNumbers = new HashSet<>();

        for (String number : splitNumbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(WINNING_LOTTO_UNIQUE_ERROR_MESSAGE.getMessage());
            }
        }
    }
}
