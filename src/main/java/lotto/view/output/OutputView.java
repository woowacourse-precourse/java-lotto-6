package lotto.view.output;

import lotto.domain.Game;

import java.util.List;

public interface OutputView {
    void printNewLine();
    void printPurchaseResult(int purchaseResult);
    void printLotto(List<Integer> lotto);
    void printGameResult(Game game);
    void printGameInterestRate(double interestRate);
}
