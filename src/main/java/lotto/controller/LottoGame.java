package lotto.controller;

import java.util.LinkedHashMap;
import java.util.List;
import lotto.constants.LottoPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.input.InputDevice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private static Money money;
    private static WinningLotto winningLotto;
    private static List<Lotto> lottos;
    private static LottoResult lottoResult;
    private static LottoPrize prize;

    public static void run() {
        handlePurchase();
        handleWinningLotto();
        handleBonusNumber();
        handleResult();
    }

    public static void handlePurchase() {
        boolean isPurchasing = true;
        InputView.printEnterAmount();
        while (isPurchasing) {
            try {
                money = new Money(InputDevice.receiveNumber());
            } catch (IllegalArgumentException e) {
                OutputView.displayError(e);
            }
            isPurchasing = false;
        }
        lottos = LottoTicket.generate(money.countNumberOfLotto());
        OutputView.displayPurchasedLotto(money.countNumberOfLotto(), lottos);
    }

    public static void handleWinningLotto() {
        boolean isCreating = true;
        InputView.printEnterWinningNumber();
        while (isCreating) {
            try {
                Lotto lotto = new Lotto(InputDevice.receiveNumbers());
                winningLotto = new WinningLotto(lotto);
            } catch (IllegalArgumentException e) {
                OutputView.displayError(e);
            }
            isCreating = false;
        }
    }

    public static void handleBonusNumber() {
        boolean isSetting = true;
        InputView.printEnterBonusNumber();
        while (isSetting) {
            try {
                winningLotto.setBounusNumber(InputDevice.receiveNumber());
            } catch (IllegalArgumentException e) {
                OutputView.displayError(e);
            }
            isSetting = false;
        }
    }

    public static void handleLotto() {
        for (Lotto lotto : lottos) {
            int count = 0;
            boolean hasBonus = false;
            count = lotto.countContainNumbers(winningLotto.getWinningNumber());
            hasBonus = lotto.checkContainNumber(winningLotto.getBounusNumber());
            if (count >= 3) {
                lottoResult.save(prize.rank(count, hasBonus));
            }
        }
    }

    public static void handleResult() {
        LinkedHashMap<LottoPrize, Integer> statistics = lottoResult.getStatistics();
        double amount = lottoResult.calculateEarningRate(money.getAmount());
        OutputView.displayWinningStatistics(statistics, amount);
    }

}
