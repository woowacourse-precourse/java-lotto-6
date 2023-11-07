package lotto;

public class InputValidator {
    public static final String MONEY_1000_UNIT_ERROR = "[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.\n";

    public static void checkMoney1000(int moneyInput) {
        if (moneyInput % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_1000_UNIT_ERROR);
        }
    }
}
