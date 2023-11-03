package lotto.view;

import lotto.domain.PurchaseAmount;

public class OutputView {

    public void showBayLottoCount(PurchaseAmount purchaseAmount){
        System.out.println(purchaseAmount.getAmount()+"개를 구매했습니다.");
    }
}