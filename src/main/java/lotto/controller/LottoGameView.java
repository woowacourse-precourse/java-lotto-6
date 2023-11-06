package lotto.controller;

import java.util.List;
import lotto.controller.dto.LottoBonusNumberCreateRequest;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.controller.dto.LottoResponse;
import lotto.controller.dto.LottoWinningNumberCreateRequest;
import lotto.controller.dto.LottoWinningStatistics;

public interface LottoGameView {
    LottoPurchaseRequest inputPurchaseRequest();

    void printPurchasedTickets(List<LottoResponse> purchasedLottoTickets);

    LottoWinningNumberCreateRequest inputLottoWinningNumberCreateRequest();

    LottoBonusNumberCreateRequest inputLottoBonusNumberCreateRequest();

    void printWinningStatistics(LottoWinningStatistics lottoWinningStatistics);

    void printException(Exception exception);
}
