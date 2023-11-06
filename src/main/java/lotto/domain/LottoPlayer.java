package lotto.domain;

import lotto.util.LottoPlayerValidator;

public class LottoPlayer {

    private static final int PRICE_OF_LOTTO = 1000;

    private final int totalPriceOfLotto;

    public LottoPlayer(String inputTotalPriceOfLotto) {
        int totalPrice = LottoPlayerValidator.validateTotalPriceOfLotto(inputTotalPriceOfLotto);
        this.totalPriceOfLotto = totalPrice;
    }

    public int calculateCountOfLotto() {
        return totalPriceOfLotto / PRICE_OF_LOTTO;
    }
}
