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

    private List<Lotto> lottos;

    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoGameController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        initGame();
        setWinningCondition();
        result();
    }

    private void initGame() {
        int lottoPurchaseAmount = inputView.requestLottoPurchaseAmount();
        this.lottos = lottoService.createLottos(lottoPurchaseAmount);
        outputView.printLottoCountOfPurchase(this.lottos.size());
        outputView.printLottos(this.lottos);
    }

    private void setWinningCondition() {
        this.winningNumbers = inputView.requestWinningNumbers();
        this.bonusNumber = inputView.requestBonusNumber(this.winningNumbers);
    }

    private void result() {
        Map<WinningPrize, Integer> winningPrizes = lottoService.getWinningPrizes(lottos, winningNumbers, bonusNumber);
        double returnOnLotto = lottoService.getReturnOnLotto(lottos, this.winningNumbers, this.bonusNumber);
        outputView.printResult(winningPrizes, returnOnLotto);
    }
}
