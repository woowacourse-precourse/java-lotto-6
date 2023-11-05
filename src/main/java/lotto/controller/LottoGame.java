package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

import static constant.MessageList.PRICE_OF_ONE_LOTTO;

public class LottoGame {
    private final LottoNumbers lottoNumbers;
    private Lotto lotto;

    public LottoGame() {
        lottoNumbers = new LottoNumbers();
        lotto = new Lotto(lottoNumbers.numbers);
    }
    public int getPurchaseQuantityOfLotto(int purchaseAmount) {
        return purchaseAmount / PRICE_OF_ONE_LOTTO;
    }
}
