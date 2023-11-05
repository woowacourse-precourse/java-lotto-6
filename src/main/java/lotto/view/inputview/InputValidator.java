package lotto.view.inputview;

import static lotto.Error.View.NOT_NUMBER;

public final class InputValidator {
    private InputValidator() {
    }
    
    public static void validateIsNumber(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getText());
        }
    }
}
