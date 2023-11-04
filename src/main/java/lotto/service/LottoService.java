package lotto.service;

import lotto.utils.constants.Comment;
import lotto.utils.constants.LottoNumConstant;

public class LottoService {

    public static int amountPurchaseDivide(int purchaseInput) {
        int lottoNumber = purchaseInput / LottoNumConstant.LOTTO_AMOUNT_PURCHASE.getNumber();
        return lottoNumber;
    }
}
