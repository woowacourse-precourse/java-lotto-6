package lotto.validator;

public class Validator {
    public Validator() {
    }

    public void validateInput(String input) {
        if (!isEmpty(input) || !isNotNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(String input) {
        return !input.isEmpty();
    }

    private boolean isNotNumeric(String input) {
        String[] inputArray = input.split(",");
        try {
            for (String numStr : inputArray) {
                Integer.parseInt(numStr);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}