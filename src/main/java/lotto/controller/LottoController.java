package lotto.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Lotto.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();
    private final int LOTTOPRICE = 1000;
    public void run() {
        List<Lotto> lottos = new ArrayList<>();
        int lottoAmount = inputPurchasePrice();
        lottos = lottoService.generateLottos(lottoAmount, lottos);

        outputView.printBuyLotto(lottoAmount);
        outputView.printTotalLotto(lottos);

        String winningNumber = inputView.inputWinningNumber();
        String bonusNumber = inputView.inputBonusNumber();

        Map<Rank, Integer> lottoResult = lottoService.checkwin(winningNumber, bonusNumber, lottos);
        outputView.printWinningStatistics();
        result(lottoResult);
        outputView.printEarningRate(checkEarningRate(lottoResult, lottoAmount * LOTTOPRICE));
    }

    public int inputPurchasePrice() {
        while (true) {
            try {
                String purchasePrice = inputView.buyLotto();
                return lottoService.checkLottoAmount(purchasePrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputPurchasePrice();
            }
        }
    }

    private void result(Map<Rank, Integer> rankCounts) {
        EnumSet.allOf(Rank.class).stream()
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> {
                    int count = rankCounts.getOrDefault(rank, 0);
                    if (rank == Rank.SECOND) {
                        outputView.printSecondResult(rank.getMatchCount(), rank.getWinningMoney(), count);
                        return;
                    }
                    outputView.printResult(rank.getMatchCount(), rank.getWinningMoney(), count);
                });
    }

    private double checkEarningRate(Map<Rank, Integer> rankCounts, int purchasePrice) {
       int totalEarning = lottoService.calculateTotalEarning(rankCounts);
       return lottoService.calculateEarningRate(totalEarning, purchasePrice);
    }
}
