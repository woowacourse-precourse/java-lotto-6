package lotto.domain;

import lotto.utility.enums.Standards;

public class LottoChanger {
    private int lottoCount;

    public LottoChanger(int purchaseAmount){
        calculateLottoCount(purchaseAmount);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private void calculateLottoCount(int purchaseAmount){
        lottoCount = purchaseAmount / Standards.ONE_LOTTO_COST.getNumber();
    }
}
