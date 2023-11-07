package lotto.view;

import lotto.domain.Lottos;

public interface OutputView {
    void printLottos(Lottos lottos);
    void printGameResult(Lottos lottos);
    void printProfit(double profit);
    void printErrorMessage(String message);
}
