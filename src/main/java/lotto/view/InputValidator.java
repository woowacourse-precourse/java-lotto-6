package lotto.view;

public class InputValidator {

    private static final String EMPTY_EXCEPTION = "값을 입력해주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자를 입력해주세요.";

    public String validateNotEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
        return inputValue;
    }

    public String validateNumberFormat(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return inputValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
