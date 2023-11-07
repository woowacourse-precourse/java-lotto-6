package lotto;

public class CashInHand {
    private static final int LOTTO_PRICE = 1000;
    private final int cash;

    public CashInHand(String stringCash) {
        int cash = isNumber(stringCash);
        isPriceMultiple(cash);
        this.cash = cash;
    }

    private int isNumber(String stringCash) {
        try {
            return Integer.parseInt(stringCash);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매금액에는 숫자를 입력하시오.");
        }
    }

    private void isPriceMultiple(int cash) {
        if (cash % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은" + LOTTO_PRICE + "의 배수를 입력하시오.");
        }
    }

    public int getCash() {
        return this.cash;
    }
}
