package lotto;

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
            throw new IllegalArgumentException();
        }
        else if (value % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getLottosSize() {
        return value / 1000;
    }
}
