package lotto.view;

import lotto.domain.PurchasedLotto;
import lotto.util.StringUtil;

public class OutputView {
    private final StringUtil stringUtil;

    public OutputView(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    public void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        String output = stringUtil.formatLottoList(purchasedLotto);
        System.out.print(output);
    }

}
