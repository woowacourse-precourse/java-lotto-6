package lotto.model;

public class UserAmount {
    private int userAmount;
    private static final int PRICE_LOTTO = 1000;

    public UserAmount(String money) {
        userAmount = Integer.parseInt(money);
    }

    public int getNumberOfLotto() {
        return userAmount / PRICE_LOTTO;
    }

    public int getAmount() {
        return userAmount;
    }
}
