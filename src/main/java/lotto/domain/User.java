package lotto.domain;

public class User {

    private int balance;
    private int lottoCount;

    public User(int balance) {
        validateBalance(balance);
        this.balance = balance;
        this.lottoCount = balance / 1000;
    }

    private void validateBalance(int balance) {
        validateCorrectRange(balance);
        validateThousandUnit(balance);
    }

    private void validateCorrectRange(int balance) {
        if(balance < 1000 || balance > 1000000000){
            throw new IllegalArgumentException("[ERROR] : 구입 금액은 1000원 이상, 10억원 이하입니다");
        }
    }

    private void validateThousandUnit(int balance) {
        if(balance % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] : 구입 금액은 1000원 단위여야 합니다");
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getBalance() {
        return balance;
    }
}
