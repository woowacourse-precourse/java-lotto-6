package lotto.domain;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    public void getLottoPrice(int money) {
        validInputMoney(money);
    }

    private void validInputMoney(int money) {
        if (money % LOTTO_PRICE != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로 판매할 수 있습니다.");
        }
    }
}
