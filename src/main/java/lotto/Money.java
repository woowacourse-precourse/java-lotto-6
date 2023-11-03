package lotto;

public class Money {

    private int money = 0;
    private static final int ONE_THOUSAND_WON = 1000;
    private static final int ZERO = 0;
    private static final String ERROR_NUMBER_MESSAGE = "[ERROR] 숫자를 입력하세요.";
    private static final String INSERT_WON_MESSAGE = "[ERROR] 1,000원 단위로 입력하세요.";

    public Money(String money) {
        this.money = validate(money);
    }

    public int currentMoney() {
        return money;
    }

    private int validate(String money) {
        validateMoney(money);

        return moneySize(money);
    }

    private void validateMoney(String money) {
        if(!money.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
    }

    private int moneySize(String money) {
        int realMoney = Integer.parseInt(money);

        if(realMoney % ONE_THOUSAND_WON != ZERO) {
            throw new IllegalArgumentException(INSERT_WON_MESSAGE);
        }

        return realMoney;
    }
}
