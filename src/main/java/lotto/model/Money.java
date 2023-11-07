package lotto.model;

public class Money {
    private final String INTEGER_RANGE = "^[0-9]+$";
    private final String ERROR_NOT_INTEGER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private final int ONE_LOTTO_PRICE = 1000;
    private final int ZERO = 0;
    private final String ERROR_NOT_PAPER_MONEY = "[ERROR] 구입 금액은 1,000원 단위로 이루어져야 합니다.";
    private final String money;

    public Money(String money) {
        validateMoney(money);
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    private void validateMoney(String money) {
        isInteger(money);
        isPaperMoney(money);
    }

    private void isInteger(String money) {
        if (!money.matches(INTEGER_RANGE)) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    private void isPaperMoney(String money) {
        int realMoney = Integer.parseInt(money);
        if (realMoney % ONE_LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_PAPER_MONEY);
        }
    }
}
