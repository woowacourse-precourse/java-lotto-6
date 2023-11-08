package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.WinnerLotto;
import lotto.service.LottoBuyService;
import lotto.service.LottoStatsService;
import lotto.service.LottoWinnerService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoBuyService lottoBuyService = new LottoBuyService();
    private final LottoWinnerService lottoWinnerService = new LottoWinnerService();
    private final LottoStatsService lottoStatsService = new LottoStatsService();
    private WinnerLotto winnerLotto;

    public void buyLotto() {
        int price;
        int lottoAmount;

        outputView.printRequestPurchasePrice();
        price = inputView.getLottoPrice();
        lottoAmount = lottoBuyService.getLottoAmount(price);
        List<Lotto> lottoPaper = lottoBuyService.exchangeLotto(lottoAmount);
        outputView.printTotalTicket(lottoAmount, lottoPaper);
    }

    public void setLottoWinner() {
        String winnerNumber;
        int bonusNumber;

        outputView.printRequestWinnerNumber();
        winnerNumber = inputView.getWinnerLotto();
        List<Integer> winnerLottoPaper = inputView.getWinnerLottoPaper(winnerNumber);
        outputView.printRequestBonusNumber();
        bonusNumber = inputView.getBonusNumber();
        winnerLotto = new WinnerLotto(winnerLottoPaper, bonusNumber);
    }

    public void endLotto() {
        List<LottoRank> rankResult = lottoWinnerService.checkRanking(winnerLotto);
        Map<LottoRank, Integer> lottoResult = lottoWinnerService.setLottoResult(rankResult);
        double returnRate = lottoStatsService.calculateReturnRate(lottoResult);
        outputView.printLottoResult(lottoResult);
        outputView.printReturnRate(returnRate);
    }
}
