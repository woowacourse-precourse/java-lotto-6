package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorType;
import lotto.exception.LottoException;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String NUMERIC_PATTERN = "\\d+";

    public List<String> toStringList(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public List<Integer> toIntegerList(final List<String> userList) {
        return userList.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public void validateDigit(final List<String> list) {
        boolean isDigit = list.stream().allMatch(s -> s.matches(NUMERIC_PATTERN));
        if (!isDigit) {
            throw new LottoException(ErrorType.OverValueException);
        }
    }

    public int toInt(final String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorType.LottoNumNotDigitException);
        }
    }
}
