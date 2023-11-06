package lotto.domain.user;

import static lotto.Option.GameOption.LOTTO_PRICE;

import lotto.validator.LottoCountValidator;

public class LottoCount {
    int lottoCount;

    public LottoCount(int money) {
        LottoCountValidator.go(money);
        lottoCount = money / LOTTO_PRICE.getNumber();
    }

    public boolean isContinue() {
        return lottoCount != 0;
    }

    public void minusCount() {
        lottoCount--;
    }
}
