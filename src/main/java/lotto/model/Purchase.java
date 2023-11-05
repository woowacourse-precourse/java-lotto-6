package lotto.model;

public class Purchase {
    private int money;

    public Purchase(int money) {
        validateAmount(money);
        this.money = money;
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
