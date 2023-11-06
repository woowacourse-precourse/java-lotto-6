package lotto.domain.amount;

public class PurchaseAmount extends Amount {

    protected PurchaseAmount(int amount) {
        super(amount);
        validate(amount);
    }

    public static PurchaseAmount from(int amount) {
        return new PurchaseAmount(amount);
    }

    @Override
    protected void validate(int amount) {
        super.validate(amount);
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
