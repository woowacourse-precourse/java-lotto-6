package lotto.domain.service;

import lotto.domain.model.LottoPrice;
import lotto.global.error.ErrorType;
public class LottoCalculator {
    public int calculateNumberOfLotto(int userPurchasePrice) {
        int lottoCount;

        try {
            if (userPurchasePrice % LottoPrice.LOTTO_PRICE.getValue() != 0) {
                throw new IllegalArgumentException(ErrorType.DIVIDABLE_1000_MESSAGE.getValue());
            }
            lottoCount = userPurchasePrice / LottoPrice.LOTTO_PRICE.getValue();
            return lottoCount;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
