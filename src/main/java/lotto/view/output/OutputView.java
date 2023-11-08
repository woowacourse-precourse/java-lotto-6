package lotto.view.output;

import java.util.List;

public interface OutputView {
    void printNewLine();
    void printLottoQuantity(int purchaseResult);
    void printPurchasedLotto(List<Integer> lotto);
    void printGameResults(List<Integer> gameResults);
    void printGameProfit(double profit);
}
