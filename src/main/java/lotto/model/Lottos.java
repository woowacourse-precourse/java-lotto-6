package lotto.model;

import camp.nextstep.edu.missionutils.Console;

public class Lottos {
    int lottoCount;

    public Lottos(){
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.calculateLootoCount();
        this.lottoCount = purchaseAmount.PurchaseCount;
    }
}
