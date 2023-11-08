package lotto.validation;

public class InputValidator {

    public boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char oneCharacter = input.charAt(i);
            if (!Character.isDigit(oneCharacter)) {
                return false;
            }
        }
        if (input.length() == 0) {
            return false;
        }
        return true;
    }
}
