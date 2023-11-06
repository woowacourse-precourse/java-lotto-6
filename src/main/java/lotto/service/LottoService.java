package lotto.service;

import lotto.exception.LottoException;
import lotto.view.LottoView;

public class LottoService {

    private LottoException lottoException = new LottoException();

    public int getLottoCount(String lottoPurchase) {
        int lottoCount = 0;
        if (lottoException.isValidLottoPurchase(lottoPurchase)) {
            lottoCount = Integer.parseInt(lottoPurchase)/1000;
        }
        return lottoCount;
    }



}
