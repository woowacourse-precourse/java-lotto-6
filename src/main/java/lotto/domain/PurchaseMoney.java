package lotto.domain;

public class PurchaseMoney {

    enum ErrorMessage {
        UNDER_1000("로또 구입 금액은 1000원 이상이어야 합니다."),
        NEGATIVE("로또 구입 금액은 음수가 될 수 없습니다."),
        ZERO("로또 구입 금액은 0원이 될 수 없습니다."),
        NOT_DIVISIBLE("로또 구입 금액은 1000원 단위여야 합니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private final Integer amount;


    public PurchaseMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validatePositive(amount);
        validateNotZero(amount);
        validateDivisibleByThousand(amount);
    }

    private void validateNotZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ErrorMessage.ZERO.getMessage());
        }
    }

    private void validatePositive(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE.getMessage());
        }
    }

    private void validateDivisibleByThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE.getMessage());
        }
    }
}
