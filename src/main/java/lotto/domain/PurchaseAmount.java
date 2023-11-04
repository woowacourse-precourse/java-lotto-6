package lotto.domain;

public class PurchaseAmount {
    private int money;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.money = amount;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int amount) {
        validateAmount(amount);
        validateIsMultipleOfThousand(amount);
    }

    private void validateAmount(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("구입 금액은 1원 이상이어야 합니다.");
        }
    }

    private void validateIsMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액이 1000원 단위이어야 합니다.");
        }
    }
}
