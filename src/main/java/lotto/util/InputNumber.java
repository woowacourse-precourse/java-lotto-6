package lotto.util;

public abstract class InputNumber implements InputValidator {
    protected final Long number;

    protected InputNumber(String input) {
        checkBlank(input);
        number = isLong(input);
        validate();
    }

    private void checkBlank(String input) {
        input = input.replaceAll(" ", "");
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private Long isLong(String input) {
        Long number;
        try {
            number = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    public abstract void validate();
}
