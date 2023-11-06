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

    public void validateBonus(String bonus, Integer start, Integer end) {
        isBonusNumeric(bonus);
        isBonusInRange(bonus, start, end);
    }

    private void isBonusNumeric(String bonus) {
        if (!bonus.matches(REGULAR_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private void isBonusInRange(String bonus, Integer start, Integer end) {
        Integer number = Integer.parseInt(bonus);

        if (number <= start || end <= number) {
            throw new IllegalArgumentException();
        }
    }
}
