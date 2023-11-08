package lotto.domain.user;

import static lotto.option.GameOption.LOTTO_PRICE;

import lotto.validator.LottoCountValidator;

public class LottoCount {
    private int count;

    private LottoCount(int count) {
        this.count = count;
    }

    public static LottoCount from(int money) {
        LottoCountValidator.check(money);
        return new LottoCount(money / LOTTO_PRICE.getNumber());
    }

    public boolean isContinue() {
        return count != 0;
    }

    public void minusCount() {
        count--;
    }
}
