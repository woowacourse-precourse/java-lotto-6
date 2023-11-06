package lotto.util.input;

public abstract class InputNumber implements InputValidator {
    protected final Integer number;

    protected InputNumber(String input) {
        checkBlank(input);
        number = isInteger(input);
        validate();
    }

    private void checkBlank(String input) {
        input = input.replaceAll(" ", "");
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private Integer isInteger(String input) {
        Integer number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    public abstract void validate();
}
