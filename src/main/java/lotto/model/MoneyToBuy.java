package lotto.model;

public class MoneyToBuy {
    private final Integer value;
    private static final Integer costOfLotto = 1000;

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
        } else if (value % costOfLotto != 0) {
            throw new IllegalArgumentException("금액은 " + costOfLotto + "원 단위이어야 합니다.");
        }
    }

    public Integer getLottosSize() {
        return value / costOfLotto;
    }
}
