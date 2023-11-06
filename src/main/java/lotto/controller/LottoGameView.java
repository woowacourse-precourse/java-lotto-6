package lotto.controller;

import java.util.List;
import lotto.view.dto.LottoBonusNumberCreateRequest;
import lotto.view.dto.LottoPurchaseRequest;
import lotto.view.dto.LottoResponse;
import lotto.view.dto.LottoWinningNumberCreateRequest;
import lotto.view.dto.LottoWinningStatistics;

public interface LottoGameView {
    LottoPurchaseRequest inputPurchaseRequest();

    void printPurchasedTickets(List<LottoResponse> purchasedLottoTickets);

    LottoWinningNumberCreateRequest inputLottoWinningNumberCreateRequest();

    LottoBonusNumberCreateRequest inputLottoBonusNumberCreateRequest();

    void printWinningStatistics(LottoWinningStatistics lottoWinningStatistics);

    void printException(Exception exception);
}
