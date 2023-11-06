package lotto.domain;

public class Amount {

    private int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateIsLessThanThousand(amount);
        validateIsDividedByThousand(amount);
    }

    private void validateIsDividedByThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsLessThanThousand(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("금액이 1000원 보다 작습니다.");
        }
    }
}
