package lotto.view;

import lotto.model.UserLotto;

public class OutputView {
    public void printPurchaseResult(int lottoCount) {
        String result = String.format(OutputMessage.PURCHASE_RESULT.getMessage(), lottoCount);
        System.out.println(result);
    }

    public void printUserLotto(UserLotto userLotto) {
        System.out.println(userLotto);
        System.out.println();
    }
}
