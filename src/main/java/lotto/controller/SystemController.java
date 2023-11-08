package lotto.controller;

import lotto.domain.Money;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningNumbersWithBonus;
import lotto.domain.WinningStats;
import lotto.view.OutputView;

public class SystemController {
    private final WinningStats winningStats;
    private final Money purchasedAmount;

    private SystemController(WinningStats winningStats, Money purchasedAmount) {
        this.winningStats = winningStats;
        this.purchasedAmount = purchasedAmount;
    }

    public static SystemController createAndPlay() {
        Money purchasedAmount = Money.createManual();
        return new SystemController(getWinningStatsFrom(purchasedAmount), purchasedAmount);
    }

    private static WinningStats getWinningStatsFrom(Money purchasedAmount) {
        return WinningStats.of(getPurchasedLottosAndPrintFrom(purchasedAmount),
                WinningNumbersWithBonus.createManual());
    }

    private static PurchasedLottos getPurchasedLottosAndPrintFrom(Money purchasedAmount) {
        PurchasedLottos purchasedLottos = PurchasedLottos.from(purchasedAmount);
        OutputView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    public void showResult() {
        OutputView.printWinningStats(winningStats);
        OutputView.printProfitMargin(purchasedAmount.getProfitMarginAsFormat(winningStats));
    }
}
