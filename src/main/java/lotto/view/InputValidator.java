package lotto.view;

public class InputValidator {

    private static final String NUMBER_FORMAT_EXCEPTION = "숫자를 입력해주세요.";

    public String validateNumberFormat(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return inputValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
