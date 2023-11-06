package lotto.validator;

public class InputValidator {

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }

    public static void isInteger(String[] inputs) {
        try {
            for (int i = 0; i < inputs.length; i++) {
                Integer.parseInt(inputs[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }
}
