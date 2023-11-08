package lotto.controller;

import lotto.model.*;
import lotto.util.LottoNumberCreator;
import lotto.util.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class MainController {
    private static LottoPrice lottoPrice;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private static TotalLotto getTotalLotto(OutputView outputView, InputView inputView) {
        outputView.printMessageForInputPurchaseAmount();
        lottoPrice = inputView.getLottoPrice();
        outputView.printNumberForPurchasedLottos(lottoPrice);
        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator(lottoPrice);
        outputView.printPurchasedLottos(lottoNumberCreator.getTotalLotto());
        return lottoNumberCreator.getTotalLotto();
    }

    private static Lotto getWinningNumberLotto(OutputView outputView, InputView inputView) {
        outputView.printMessageForWinningNumbers();
        WinningNumber winningNumber = inputView.getWinningNumbers();
        return winningNumber.getLotto();
    }

    private static BonusNumber getBonusNumber(OutputView outputView, InputView inputView) {
        outputView.printMessageForBonusNumber();
        return inputView.getBonusNumber();
    }

    public void startLottoProgram() {
        TotalLotto totalLotto = getTotalLotto(outputView, inputView);
        Lotto winningNumberLotto = getWinningNumberLotto(outputView, inputView);
        BonusNumber bonusNumber = getBonusNumber(outputView, inputView);
        outputView.printMessageLotteryStatistics();
        checkResult(totalLotto, winningNumberLotto, bonusNumber);
        checkProfit(lottoPrice);

    }

    private void checkResult(TotalLotto totalLotto, Lotto winningNumberLotto, BonusNumber bonusNumber) {
        for (Lotto lotto : totalLotto.getLottoList()) {
            checkWhoIs1(lotto, winningNumberLotto);
            checkWhoIs2(lotto, winningNumberLotto, bonusNumber);
            checkWhoIs3(lotto, winningNumberLotto, bonusNumber);
            checkWhoIs4(lotto, winningNumberLotto);
            checkWhoIs5(lotto, winningNumberLotto);
        }
        outputView.printLotteryStatisticsFor_5(WinningRank.FIFTH.getCount());
        outputView.printLotteryStatisticsFor_4(WinningRank.FOURTH.getCount());
        outputView.printLotteryStatisticsFor_3(WinningRank.THIRD.getCount());
        outputView.printLotteryStatisticsFor_2(WinningRank.SECOND.getCount());
        outputView.printLotteryStatisticsFor_1(WinningRank.FIRST.getCount());
    }

    private void checkWhoIs1(Lotto lotto, Lotto winningNumberLotto) {
        int matchingNumbers = countMatchingNumbers(lotto, winningNumberLotto);
        if (matchingNumbers == 6) {
            // 1등 당첨
            WinningRank.FIRST.increaseRankCount();

        }
    }

    private void checkWhoIs2(Lotto lotto, Lotto winningNumberLotto, BonusNumber bonusNumber) {
        int matchingNumbers = countMatchingNumbers(lotto, winningNumberLotto);
        boolean bonusNumberMatch = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
        if (matchingNumbers == 5 && bonusNumberMatch) {
            // 2등 당첨
            WinningRank.SECOND.increaseRankCount();
        }
    }

    private void checkWhoIs3(Lotto lotto, Lotto winningNumberLotto, BonusNumber bonusNumber) {
        int matchingNumbers = countMatchingNumbers(lotto, winningNumberLotto);
        boolean bonusNumberMatch = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
        if (matchingNumbers == 5 && !bonusNumberMatch) {
            // 3등 당첨
            WinningRank.THIRD.increaseRankCount();
        }
    }

    private void checkWhoIs4(Lotto lotto, Lotto winningNumberLotto) {
        int matchingNumbers = countMatchingNumbers(lotto, winningNumberLotto);
        if (matchingNumbers == 4) {
            // 4등 당첨
            WinningRank.FOURTH.increaseRankCount();
        }
    }

    private void checkWhoIs5(Lotto lotto, Lotto winningNumberLotto) {
        int matchingNumbers = countMatchingNumbers(lotto, winningNumberLotto);
        if (matchingNumbers == 3) {
            // 5등 당첨
            WinningRank.FIFTH.increaseRankCount();
        }
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningNumberLotto) {
        List<Integer> userNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumberLotto.getNumbers();

        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void checkProfit(LottoPrice lottoPrice) {
        float earnedMoney = WinningRank.FIRST.getPrice() * WinningRank.FIRST.getCount()
                + WinningRank.SECOND.getPrice() * WinningRank.SECOND.getCount()
                + WinningRank.THIRD.getPrice() * WinningRank.THIRD.getCount()
                + WinningRank.FOURTH.getPrice() * WinningRank.FOURTH.getCount()
                + WinningRank.FIFTH.getPrice() * WinningRank.FIFTH.getCount();
        float totalSpentMoney = lottoPrice.getPrice();
        float profitPercentage = (float) Math.round((earnedMoney / totalSpentMoney)*100 * 10) / 10;
        outputView.printTotalProfitPercentage(profitPercentage);

    }
}

