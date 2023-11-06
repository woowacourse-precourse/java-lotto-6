package lotto;

import static lotto.Application.LOTTO_PRICE_UNIT;

public class PurchasePrice {

    private int price;

    public PurchasePrice(int price) {
        if (price % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE_UNIT + "원 단위로 입력해야 합니다.");
        }
        if (price < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 로또 금액 " + LOTTO_PRICE_UNIT + "원 이상이어야 합니다.");
        }
        this.price = price;
    }

    public int getPurchaseCount() {
        return price / LOTTO_PRICE_UNIT;
    }

    public int getPrice() {
        return price;
    }
}
