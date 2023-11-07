package lotto.view;

import lotto.domain.Lotto;

public class OutputView {

    public void printPurchaseAmount(int amount) {
        System.out.println(OutputMessage.OUTPUT_PURCHASE_AMOUNT_MESSAGE.getMessage(amount));
    }

    public void printLotto(Lotto lotto) {
        System.out.println(OutputMessage.OUTPUT_LOTTO_MESSAGE.getMessage(lotto));
    }
}
