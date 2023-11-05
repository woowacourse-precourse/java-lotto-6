package lotto.view.output;

import java.util.List;

public interface OutputView {
    void printCostMessage();
    void printNewLine();
    void printPurchaseResult(int purchaseResult);
    void printLotto(List<Integer> lotto);
    void printWinnerNumberMessage();
}
