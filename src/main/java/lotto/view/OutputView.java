package lotto.view;

import lotto.domain.Lotto;
import lotto.enums.OutputMessageEnum;

public class OutputView {

    public void printPurchaseAmount(int amount) {
        System.out.println(OutputMessageEnum.OUTPUT_PURCHASE_AMOUNT_MESSAGE.getMessage(amount));
    }

    public void printLotto(Lotto lotto) {
        System.out.println(OutputMessageEnum.OUTPUT_LOTTO_MESSAGE.getMessage(lotto));
    }
}
