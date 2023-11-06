package lotto.controller;

import lotto.domain.Money;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningNumbersWithBonus;
import lotto.domain.WinningStats;
import lotto.view.OutputView;

public class SystemController {
    private final WinningStats winningStats;
    private final Money purchasedAmount;

    private SystemController() {
        purchasedAmount = Money.createManual();
        winningStats = getWinningStats();
    }

    public static SystemController create() {
        return new SystemController();
    }

    public WinningStats getWinningStats() {
        PurchasedLottos purchasedLottos = PurchasedLottos.from(purchasedAmount);
        OutputView.printPurchasedLottos(purchasedLottos);
        return WinningStats.of(purchasedLottos, WinningNumbersWithBonus.createManual());
    }

    public void showResult() {
        OutputView.printWinningStats(winningStats);
        OutputView.printProfitMargin(purchasedAmount.getProfitMargin(winningStats));
    }
}
