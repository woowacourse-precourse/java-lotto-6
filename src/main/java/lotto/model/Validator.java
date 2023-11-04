package lotto.model;

public class Validator {
    private final String REGULAR_NUMBER = "\\d+";

    public void validateCost(String cost) {
        isCostNumeric(cost);
    }

    private void isCostNumeric(String cost) {
        if (!cost.matches(REGULAR_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
