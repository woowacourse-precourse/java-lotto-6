package lotto.model;

public class Validator {
    private final String REGULAR_NUMBER = "\\d+";

    public void validateCost(String cost, Integer lottoPrice) {
        isCostNumeric(cost);
        isCostThousands(cost, lottoPrice);
    }

    private void isCostNumeric(String cost) {
        if (!cost.matches(REGULAR_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private void isCostThousands(String cost, Integer lottoPrice) {
        if (Integer.parseInt(cost) % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isAnswerNumeric(String number) {
        if (!number.matches(REGULAR_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
