package lotto.domain;

public record LottoMoney(int money) {
    private static final int LOTTO_PRICE = 1000;

    public LottoMoney {
        validateMoney(money);
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }
}
