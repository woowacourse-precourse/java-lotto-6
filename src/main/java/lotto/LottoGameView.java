package lotto;

import java.util.List;
import lotto.dto.LottoBonusNumberCreateRequest;
import lotto.dto.LottoPurchaseRequest;
import lotto.dto.LottoWinningNumberCreateRequest;
import lotto.dto.LottoWinningStatistics;

public interface LottoGameView {
    LottoPurchaseRequest inputPurchaseRequest();

    void printPurchasedTickets(List<Lotto> purchasedLottoTickets);

    LottoWinningNumberCreateRequest inputLottoWinningNumberCreateRequest();

    LottoBonusNumberCreateRequest inputLottoBonusNumberCreateRequest();

    void printWinningStatistics(LottoWinningStatistics lottoWinningStatistics);

    void printException(Exception exception);
}
