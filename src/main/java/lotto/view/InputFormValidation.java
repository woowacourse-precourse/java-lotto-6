package lotto.view;

public class InputFormValidation {
    public void isNumber(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.IS_NOT_NUMBER_ERROR);
        }
    }

    public void areNumbers(String[] split) {
        try {
            for (String number : split) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.IS_NOT_NUMBER_ERROR);
        }
    }
}
