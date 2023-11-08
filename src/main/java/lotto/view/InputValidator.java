package lotto.view;

import static lotto.exception.ErrorType.LottoNumNotDigitException;
import static lotto.exception.ErrorType.OverValueException;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String NUMERIC_PATTERN = "\\d+";

    public List<String> toStringList(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public List<Integer> toIntegerList(final List<String> userNumbers) {
        return userNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public void validateDigit(final List<String> unValidated) {
        boolean isDigit = unValidated.stream().allMatch(s -> s.matches(NUMERIC_PATTERN));
        if (!isDigit) {
            throw new LottoException(OverValueException);
        }
    }

    public int toInt(final String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoNumNotDigitException);
        }
    }
}
