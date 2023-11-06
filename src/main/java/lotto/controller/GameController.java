package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.wrapper.PurchaseAmout;
import lotto.service.VendingMachine;
import lotto.service.PrizeManager;
import lotto.utils.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void play() {
        PurchaseAmout purchaseAmout = getPurchaseAmout();
        Lottos plyerLottos = buyLottos(purchaseAmout);
        printLottos(plyerLottos);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        PrizeManager prizeManager = new PrizeManager(winningNumbers, bonusNumber, plyerLottos);
        printPrizeResults(prizeManager);
        printPrizeProfit(prizeManager, purchaseAmout);
    }

    private PurchaseAmout getPurchaseAmout() {
        outputView.printGetPurchaseAmountMessage();
        return new PurchaseAmout(inputView.getPurchaseAmount());
    }

    private Lottos buyLottos(PurchaseAmout purchaseAmout) {
        VendingMachine vendingMachine = new VendingMachine(purchaseAmout);
        return vendingMachine.getLottos();
    }

    private void printLottos(Lottos playerLottos) {
        outputView.printBuyingMessage(playerLottos.getLottoCount());
        outputView.printLottos(playerLottos.toString());
    }

    private List<Integer> getWinningNumbers() {
        outputView.printGetWinningNumbersMessage();
        return inputView.getWinningNumbers();
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        outputView.printGetBonusNumberMessage();
        return inputView.getBonusNumber(winningNumbers);
    }

    private void printPrizeResults(PrizeManager prizeManager) {
        outputView.printPrizeMessageStartMessage();
        Map<Prize, Integer> prizeCounts = prizeManager.getPrizeCounts();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NO_PRIZE) {
                continue;
            }
            outputView.printPrizeMessages(prize.getSameCount(), prize.getPrizeProfit(), prizeCounts.get(prize));
        }
    }

    private void printPrizeProfit(PrizeManager prizeManager, PurchaseAmout purchaseAmout) {
        outputView.printProfitRate(prizeManager.getProfitRate(purchaseAmout));
    }
}
