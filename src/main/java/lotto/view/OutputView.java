package lotto.view;

import lotto.dto.LottoStatisticsResult;
import lotto.dto.LottoTickets;

public interface OutputView {
    void requestPurchaseAmount();

    void printLottoTickets(LottoTickets lottoTickets);

    void requestLottoWinningNumbers();

    void requestBonusLottoNumber();

    void printLottoStatisticsResult(LottoStatisticsResult lottoStatisticsResult);

    void printExceptionMessage(String exceptionMessage);
}
