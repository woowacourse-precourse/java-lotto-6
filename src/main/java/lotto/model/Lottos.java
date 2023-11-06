package lotto.model;

import camp.nextstep.edu.missionutils.Console;

public class Lottos {
    int lottoCount;

    public Lottos(){
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.generateLottoCount();
        this.lottoCount = purchaseAmount.purchaseCount;
    }
}
