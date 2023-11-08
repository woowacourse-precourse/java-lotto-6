package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningPrize;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchasedAmount = inputView.requestLottoPurchaseAmount();
        List<Lotto> lottos = buyLottos(purchasedAmount);

        List<Integer> winningNumbers = inputView.requestWinningNumbers();
        int bonusNumber = inputView.requestBonusNumber(winningNumbers);

        Map<WinningPrize, Integer> winningPrizes = lottoService.getWinningPrizes(lottos, winningNumbers, bonusNumber);
        double returnOnLotto = lottoService.getRateOfReturn(lottos, winningNumbers, bonusNumber);

        outputView.printResult(winningPrizes, returnOnLotto);
    }

    private List<Lotto> buyLottos(int lottoPurchaseAmount) {
        List<Lotto> lottos = lottoService.createLottos(lottoPurchaseAmount);
        outputView.printLottoCount(lottos.size());
        outputView.printLottos(lottos);
        return lottos;
    }
}
