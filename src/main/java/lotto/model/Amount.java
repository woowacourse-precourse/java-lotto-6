package lotto.model;

public class Amount {
    private int money;

    public Amount(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validatePayAble(money);
    }

    private void validatePayAble(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000 단위로만 입력 가능합니다.");
        }
    }
}
