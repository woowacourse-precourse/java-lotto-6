package lotto.domain;

public class Payment {

    private final int amount;

    public Payment(final String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(final String amount) {
        validateMinimumAmount(amount);
        validateThousandUnit(amount);
    }

    private void validateMinimumAmount(final String amount) {
        if (Integer.parseInt(amount) < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원 입니다.");
        }
    }

    private void validateThousandUnit(final String amount) {
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위 입니다.");
        }
    }

}
