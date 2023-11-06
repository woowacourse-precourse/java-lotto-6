package lotto.model;

public class UserAmount {
    private int userAmount;

    public UserAmount(int money) {
        userAmount = money;
    }

    public int getNumberOfLotto() {
        return userAmount / 1000;
    }


}
