package lotto.domain;


import lotto.utils.ErrorMessage;

public class UserPrice {

    private final int price;
    private static final int LOTTO_PRICE = 1000;

    public UserPrice(int price) {
        validate(price);
        this.price = price;
    }

    private static void validate(int price) {
        priceUnit(price);
    }

    private static void priceUnit(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.USER_PRICE_UNIT_TO_ONE_THOUSAND.getMessage());
        }
    }

    public int buyCount(int lottoPrice) {
        return price / lottoPrice;
    }

    public Lotties buy(int lottoPrice) {
        int lottoCnt = price / lottoPrice;
        return LottoFactory.generateLotties(lottoCnt);
    }

    public int getPrice() {
        return price;
    }

}
