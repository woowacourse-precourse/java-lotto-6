package lotto.model;

public class MoneyToBuy {
    private final Integer value;

    public MoneyToBuy(Integer value) {
        validate(value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private void validate(Integer value) {
        if (value <= 0) {
            throw new IllegalArgumentException("금액은 양수여야 합니다.");
        }
        else if (value % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위이어야 합니다.");
        }
    }

    public Integer getLottosSize() {
        return value / 1000;
    }
}
