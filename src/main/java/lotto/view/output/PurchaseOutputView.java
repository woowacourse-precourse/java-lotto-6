package lotto.view.output;

import static lotto.Constants.PURCHASED_AMOUNT;

public class PurchaseOutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + PURCHASED_AMOUNT);
    }
}
