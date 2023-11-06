package lotto.view;

import lotto.constant.LottoMessage;

public class LottoView {

    public void readPurchaseAmount() {
        write(LottoMessage.getPurchaseAmountInputMessage());
    }

    private void write(String output) {
        System.out.println(output);
    }
}
