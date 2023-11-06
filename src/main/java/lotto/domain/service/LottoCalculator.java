package lotto.domain.service;

import lotto.domain.controller.MainController;
import lotto.domain.model.LottoPrice;
import lotto.global.error.ErrorType;

public class LottoCalculator {
    public int calculateNumberOfLotto(int userPurchasePrice) {
        int lottoCount = userPurchasePrice / LottoPrice.LOTTO_PRICE.getValue();
        return lottoCount;
    }
}
