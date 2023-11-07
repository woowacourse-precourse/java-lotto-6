package view;

import dto.LottoStatisticsResult;
import dto.LottoTickets;

public interface OutputView {
    void requestPurchaseAmount();

    void printLottoTickets(LottoTickets lottoTickets);

    void requestLottoWinningNumbers();

    void requestBonusLottoNumber();

    void printLottoStatisticsResult(LottoStatisticsResult lottoStatisticsResult);
}
