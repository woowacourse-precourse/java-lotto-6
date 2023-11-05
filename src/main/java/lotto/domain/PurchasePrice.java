package lotto.domain;

public class PurchasePrice {

    private final int price;
    public static final int LOTTO_PRICE = 1000;
    private static final String PRICE_IS_NOT_FORMATTED_MESSAGE = "[ERROR] 로또의 가격이 맞지 않습니다.";

    public PurchasePrice(int price) {
        this.price = price;
        validate();
    }

    public int getLottoCount() {
        return price / LOTTO_PRICE;
    }

    private void validate() {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalStateException(PRICE_IS_NOT_FORMATTED_MESSAGE);
        }
    }
}
