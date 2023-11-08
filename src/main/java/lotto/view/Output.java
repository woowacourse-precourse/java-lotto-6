package lotto.view;

import lotto.domain.dto.LottoResults;
import lotto.domain.model.Lottos;

public interface Output {

    void displayInputRequest(String announce);

    void printPurchasedLottos(Lottos lottos);

    void printWinningStatistics(LottoResults winningStatistics);

    void printTotalEarningsRate(double earningsRate);

    void printError(String errorMessage);
}
