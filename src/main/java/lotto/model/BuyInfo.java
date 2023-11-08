package lotto.model;

public class BuyInfo {

    static final String AMOUNT_IS_NOT_DIVIDED_BY_1000 = "1000원 단위의 금액을 입력해주세요.";

    private int buyAmount;
    private int buyNumber;

    public BuyInfo(int buyAmount) {
        validate(buyAmount);
        this.buyAmount = buyAmount;
        this.buyNumber = amountToNumber(buyAmount);
    }

    private void validate(int buyAmount) {
        if (buyAmount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_DIVIDED_BY_1000);
        }
    }

    private int amountToNumber(int buyAmount) {
        return buyAmount / 1000;
    }

}
