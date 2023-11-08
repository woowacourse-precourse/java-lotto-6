package lotto.controller;

import java.util.ArrayList;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        ArrayList<Lotto> lottos = generateLottoAndPrint(purchaseAmount);
        WinningLotto winningLotto = getWinningLotto();
        Map<Rank, Integer> winningRankCount = getStatisticsMapAndPrint(lottos, winningLotto);
        getProfitRateAndPrint(purchaseAmount, winningRankCount);
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            int input = inputView.inputPurchaseAmount();
            return new PurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getPurchaseAmount();
        }
    }

    private ArrayList<Lotto> generateLottoAndPrint(PurchaseAmount purchaseAmount) {
        ArrayList<Lotto> lottos = lottoService.generateLotto(purchaseAmount);

        outputView.printPurchaseLottoNumbers(lottos);
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        try {
            ArrayList<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();
            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getWinningLotto();
        }
    }

    private Map<Rank, Integer> getStatisticsMapAndPrint(ArrayList<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> winningRankCount = lottoService.generateLottoStatistics(
                winningLotto, lottos);

        outputView.printStatisticsMessage();
        outputView.printLottoStatistics(winningRankCount);
        return winningRankCount;
    }

    private void getProfitRateAndPrint(PurchaseAmount purchaseAmount, Map<Rank, Integer> winningRankCount) {
        double profitRate = lottoService.calculateProfitRate(winningRankCount, purchaseAmount);

        outputView.printProfitRate(profitRate);
    }
}