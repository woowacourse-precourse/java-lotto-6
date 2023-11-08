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

    public static void run() {
        lottoResult = new LottoResult();
        handlePurchase();
        handleWinningLotto();
        handleBonusNumber();
        handleLotto();
        handleResult();
    }

    public static void handlePurchase() {
        boolean isPurchasing = true;
        InputView.printEnterAmount();
        while (isPurchasing) {
            try {
                money = new Money(InputDevice.receiveNumber());
                isPurchasing = false;
            } catch (IllegalArgumentException e) {
                OutputView.displayError(e);
            }
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
                isCreating = false;
            } catch (IllegalArgumentException e) {
                OutputView.displayError(e);
            }
        }
    }

    public static void handleBonusNumber() {
        boolean isSetting = true;
        InputView.printEnterBonusNumber();
        while (isSetting) {
            try {
                winningLotto.setBounusNumber(InputDevice.receiveNumber());
                isSetting = false;
            } catch (IllegalArgumentException e) {
                OutputView.displayError(e);
            }
        }
    }

    public static void handleLotto() {
        for (Lotto lotto : lottos) {
            int count = 0;
            boolean hasBonus = false;
            count = lotto.countContainNumbers(winningLotto.getWinningNumber());
            hasBonus = lotto.checkContainNumber(winningLotto.getBounusNumber());
            if (count >= 3) {
                lottoResult.save(LottoPrize.rank(count, hasBonus));
            }
        }
    }

    public static void handleResult() {
        LinkedHashMap<LottoPrize, Integer> statistics = lottoResult.getStatistics();
        double amount = lottoResult.calculateEarningRate(money.getAmount());
        OutputView.displayWinningStatistics(statistics, amount);
    }

}
