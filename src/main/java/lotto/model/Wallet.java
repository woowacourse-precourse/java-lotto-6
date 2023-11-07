package lotto.model;

public class Wallet {
    private int money;

    public Wallet(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        validateNonNumericMoney(money);
    }

    private void validateNonNumericMoney(String money) {
        if (!money.matches("^[0-9]*")) {
            throw new IllegalArgumentException("[Error] 구입 금액에 숫자가 아닌 값이 들어왔습니다.");
        }
    }
}
