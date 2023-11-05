package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningStats;
import lotto.view.OutputView;

public class SystemController {
    private final WinningStats winningStats;

    private SystemController() {
        winningStats = getWinningStats();
    }

    public static SystemController create() {
        return new SystemController();
    }

    public WinningStats getWinningStats() {
        PurchasedLottos purchasedLottos = PurchasedLottos.from(Money.createManual());
        OutputView.printPurchasedLottos(purchasedLottos);
        return WinningStats.of(purchasedLottos, Lotto.createWinningNumbers(), BonusNumber.createManual());
    }
}
