package lotto.view.output;

import lotto.domain.Game;

import java.util.List;

public interface OutputView {
    void printCostMessage();
    void printNewLine();
    void printPurchaseResult(int purchaseResult);
    void printLotto(List<Integer> lotto);
    void printWinnerNumberMessage();
    void printBonusNumberMessage();
    void printGameResult(Game game);
    void printGameInterestRate(double interestRate);
}
