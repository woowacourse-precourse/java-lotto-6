package lotto.domain;

public class UserBalance {

    private int balance;

    public UserBalance(int balance) {
        validateBalance(balance);
        this.balance = balance;
    }

    private void validateBalance(int balance) {
        validateThousandUnit(balance);
    }

    private void validateThousandUnit(int balance) {
        if(balance % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] : 구입 금액은 1000원 단위여야 합니다");
        }
    }
}
