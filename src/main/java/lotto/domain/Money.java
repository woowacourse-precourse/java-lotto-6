package lotto.domain;

public class Money {

    private final Integer amount;

    public Money(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상만 입력 가능합니다.");
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로만 입력 가능합니다.");
        }
    }

    public Integer getAmount() {
        return amount;
    }
}
