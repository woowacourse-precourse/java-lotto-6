package lotto.domain;

public class LottoQuantity {
    private static final String UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String MONEY_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000,000원 이하로 입력해야 합니다.";

    private static final int MAX_PURCHASE_PRICE = 1000000;
    private static final int LOTTO_ONE_PRICE = 1000;
    private final int quantity;

    private LottoQuantity(int money) {
        validateUnit(money);
        validateAmountSize(money);
        this.quantity = money / LOTTO_ONE_PRICE;
    }

    public static int of(int money) {
        return new LottoQuantity(money).quantity;
    }

    private void validateUnit(int money) {
        if (money % LOTTO_ONE_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }

    private void validateAmountSize(int money) {
        if (money > MAX_PURCHASE_PRICE) {
            throw new IllegalArgumentException(MONEY_AMOUNT_ERROR_MESSAGE);
        }
    }
}
