package lotto;

public class Validator {

    static Boolean validationFlag = true;

    public static boolean isInputEmpty(String userInput) {
        try {
            if (userInput.isEmpty()) {
                throw new IllegalArgumentException("");
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }
}
