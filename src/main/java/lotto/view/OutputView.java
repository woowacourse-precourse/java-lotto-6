package lotto.view;

import lotto.domain.Lottos;

public interface OutputView {
    void printLottos(Lottos lottos);
    void printGameResult();
    void printProfit();
    void printErrorMessage(String message);
}
