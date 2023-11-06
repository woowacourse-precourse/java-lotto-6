package lotto.util;

public class WinningNumbersValidator {

    private static final String DELIMITER = ",";

    public void validate(String userInput) throws IllegalArgumentException {
        String[] splitUserInput = userInput.split(DELIMITER);
        Validator validator = new Validator();
        for (String string : splitUserInput) {
            validator.validate(string);
        }
    }
}
