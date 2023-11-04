package lotto.view;

import static lotto.view.LottoGameMessage.COUNT_OF_PURCHASED_LOTTO;
import static lotto.view.LottoGameMessage.REQUEST_PURCHASE_AMOUNT;

public class ConsoleOutputView {
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
    }

    public void printCountOfLotto(int count) {
        printBlankLine();
        System.out.printf(COUNT_OF_PURCHASED_LOTTO.getMessage(), count);
    }

    private void printBlankLine() {
        System.out.println();
    }
}
