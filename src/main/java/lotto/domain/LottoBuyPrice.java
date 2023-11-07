package lotto.domain;

public class LottoBuyPrice {

    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public LottoBuyPrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (!isPositiveNumber(price) || !isAllowedAmountUnit(price)) {
            throw new IllegalArgumentException("유효하지 않은 로또 구입 금액입니다.");
        }
    }

    private boolean isPositiveNumber(int price) {
        return price > 0;
    }

    private boolean isAllowedAmountUnit(int price) {
        return price % LOTTO_PRICE == 0;
    }

    public static int countTotalLottoPrice(int lottoCount) {
        return LOTTO_PRICE * lottoCount;
    }

    public int getAvailableLottoBuyCount() {
        return price / LOTTO_PRICE;
    }
}
