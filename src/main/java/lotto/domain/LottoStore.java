package lotto.domain;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;
    public static final String LOTTO_PRICE_PER_THOUSAND = "[ERROR] 로또 금액은 %d원 단위로 판매할 수 있습니다.";

    public int getLottoPrice(int money) {
        validInputMoney(money);
        return sellLotto(money);
    }

    private void validInputMoney(int money) {
        if (money % LOTTO_PRICE != 0 || money <= 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_PER_THOUSAND);
        }
    }

    private int sellLotto(int money) {
        return money / LOTTO_PRICE;
    }
}
