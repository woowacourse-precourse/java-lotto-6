package lotto.view;

public class InputValidator {

    private static final String EMPTY_EXCEPTION = "값을 입력해주세요.";
    private static final String DIGIT_EXCEPTION = "숫자를 입력해주세요.";
    private static final String NUMBER_AND_DELIMITER_FORMAT_EXCEPTION = "숫자와 %c로 입력해주세요.";
    private static final String DIGIT_REGEX = "\\d";
    private static final String EMPTY = "";
    private static final char SPACE = ' ';
    private static final char DELIMITER = ',';

    public String validateNotEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
        return inputValue;
    }

    public String validateDigit(String inputValue) {
        if (0 < inputValue.replaceAll(DIGIT_REGEX, EMPTY).length()) {
            throw new IllegalArgumentException(DIGIT_EXCEPTION);
        }
        return inputValue;
    }

    public String validateNumberAndDelimiterFormat(String inputValue) {
        for (char c : inputValue.toCharArray()) {
            if (c == SPACE) continue;
            if (isNotDigitOrDelimiter(c)) {
                throw new IllegalArgumentException(String.format(NUMBER_AND_DELIMITER_FORMAT_EXCEPTION, DELIMITER));
            }
        }
        return inputValue;
    }

    private boolean isNotDigitOrDelimiter(char c) {
        return !(Character.isDigit(c) || c == DELIMITER);
    }
}
