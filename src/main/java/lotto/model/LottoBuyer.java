package lotto.model;

public class LottoBuyer {

    private static final String MONEY_IS_NOT_DIVIDED_BY_LOTTO_PRICE = "1000원 단위의 금액으로 구매가 가능합니다.";
    private static final int LOTTO_PRICE = 1000;

    private int buyAmount;
    private int numbersToBuy;

    public LottoBuyer(int buyAmount) {
        checkBuyAvailabilty(buyAmount);
        this.buyAmount = buyAmount;
        this.numbersToBuy = calculateNumbersToBuy(buyAmount);
    }

    private void checkBuyAvailabilty(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_IS_NOT_DIVIDED_BY_LOTTO_PRICE);
        }
    }

    private int calculateNumbersToBuy(int buyAmount) {
        return buyAmount / LOTTO_PRICE;
    }

}
