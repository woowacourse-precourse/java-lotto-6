package lotto.domain;

import lotto.util.LottoPriceValidator;

public class LottoPlayer {

    private static final int PRICE_OF_LOTTO = 1000;

    private final int totalPriceOfLotto;

    public LottoPlayer(String inputTotalPriceOfLotto) {
        this.totalPriceOfLotto = LottoPriceValidator.validateTotalPriceOfLotto(inputTotalPriceOfLotto);
    }

    public int calculateCountOfLotto() {
        return totalPriceOfLotto / PRICE_OF_LOTTO;
    }
}
