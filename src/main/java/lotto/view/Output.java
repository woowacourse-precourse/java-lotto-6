package lotto.view;

import lotto.domain.LottoResults;
import lotto.domain.Lottos;

public interface Output {

    void displayInputRequest(String announce);
    void printPurchasedLottos(Lottos lottos);
    void printWinningStatistics(LottoResults winningStatistics);
    void printTotalEarningsRate(double earningsRate);
    void printError(String errorMessage);
}
