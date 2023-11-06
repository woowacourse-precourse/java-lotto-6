package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoResponse;

public interface OutputView {

    void printMoneyRequestMessage();

    void printPurchasedLottos(List<LottoResponse> lottos);

    void printWinningNumberRequestMessage();

    void printBonusNumberRequestMessage();

    void printWinningStatistics(Map<String, Long> winningCount);

    void printTotalProfit(long totalPrize, long money);

    void printErrorMessage(String message);
}
