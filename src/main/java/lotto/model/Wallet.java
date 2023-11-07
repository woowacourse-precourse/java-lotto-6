package lotto.model;

public class Wallet {
    private static final int MAXIMUM_PURCHASE_AMOUNT =  1000000000;

    private int money;

    public Wallet(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        validateNotNullMoney(money);
        validateNonNumericMoney(money);
    }

    private void validateNonNumericMoney(String money) {
        if (!money.matches("^[0-9]*")) {
            throw new IllegalArgumentException("[Error] 구입 금액에 숫자가 아닌 값이 들어왔습니다.");
        }
    }

    private void validateNotNullMoney(String money) {
        if (money == null) {
            throw new IllegalArgumentException("[Error] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
                    + MAXIMUM_PURCHASE_AMOUNT + "원.");
        }
    }
}
