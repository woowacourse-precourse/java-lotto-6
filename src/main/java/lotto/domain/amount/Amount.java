package lotto.domain.amount;

public class Amount {

    protected int amount;

    protected Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Amount of(int amount) {
        // 공통 생성 로직
        return new Amount(amount);
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
