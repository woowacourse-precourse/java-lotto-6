package lotto.controller;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void playLotto() {
        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.purchaseLottoTickets(purchaseAmount);
        outputView.displayLottoTickets(lottoTickets);
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        Map<LottoRank, Integer> results = lottoService.checkWinningResults(lottoTickets, winningNumbers, bonusNumber);
        outputView.displayResults(results);
        outputView.displayProfitRate(lottoService.calculateProfitRate(results, lottoTickets.size()));
    }
}
