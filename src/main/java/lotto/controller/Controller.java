package lotto.controller;

import lotto.domain.*;
import lotto.utils.LottoNumberGenerator;
import lotto.utils.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    public void run() {
        LottoPrice lottoPrice = InputView.getLottoPrice();
        int lottoCount = lottoPrice.getPrice() / 1000;
        OutputView.purchaseComplete(lottoCount);
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(lottoCount);
        OutputView.lottoNumbers(lottoNumberGenerator.getTotalLotto());
        WinningNumber winningNumber = InputView.getWinningNumber();
        BonusNumber bonusNumber = InputView.getBonusNumber(winningNumber);
        OutputView.winningStatistics();
        checkResult(lottoNumberGenerator.getTotalLotto(), winningNumber, bonusNumber);
        OutputView.showRankResult();
        OutputView.showEarningRate(calculateEarningRate(lottoCount));
    }

    private int countMatchingNumbers(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getLotto().getNumbers();

        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void checkRank(Lotto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchingNumbers = countMatchingNumbers(lotto, winningNumber);
        boolean bonusNumberMatchResult = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
        if (matchingNumbers == 6) {
            WinningRank.FIRST.increaseRankCount();
        } else if (matchingNumbers == 5 && bonusNumberMatchResult) {
            WinningRank.SECOND.increaseRankCount();
        } else if (matchingNumbers == 5 && !bonusNumberMatchResult) {
            WinningRank.THIRD.increaseRankCount();
        } else if (matchingNumbers == 4) {
            WinningRank.FOURTH.increaseRankCount();
        } else if (matchingNumbers == 3) {
            WinningRank.FIFTH.increaseRankCount();
        }
    }

    private void checkResult(TotalLotto totalLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : totalLotto.getTotalLotto()) {
            checkRank(lotto, winningNumber, bonusNumber);
        }
    }

    private float calculateEarningRate(int lottoCount) {
        int totalReward = WinningRank.FIRST.getReward() * WinningRank.FIRST.getCount()
                + WinningRank.SECOND.getReward() * WinningRank.SECOND.getCount()
                + WinningRank.THIRD.getReward() * WinningRank.THIRD.getCount()
                + WinningRank.FOURTH.getReward() * WinningRank.FOURTH.getCount()
                + WinningRank.FIFTH.getReward() * WinningRank.FIFTH.getCount();

        return (float) Math.round(totalReward / lottoCount) / 10;
    }
}
