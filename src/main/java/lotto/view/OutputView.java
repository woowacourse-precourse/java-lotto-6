package lotto.view;

import lotto.Lotto;
import lotto.domain.PurchaseAmount;

public class OutputView {

    public void showBayLottoCount(PurchaseAmount purchaseAmount){
        System.out.println(purchaseAmount.getAmount()+"개를 구매했습니다.");
    }


    public static void showBayLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }
}