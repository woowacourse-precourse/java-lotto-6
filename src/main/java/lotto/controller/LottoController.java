package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import javax.swing.ImageIcon;
import lotto.domain.LottoCost;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPrize;
import lotto.domain.LottoPrizeCount;
import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int totalCost = getLottoCost();
        int lottoCount = LottoCost.getLottoCount(totalCost);

        Lottos lottos = generateLotto(lottoCount);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonnusNumber();
        WinningNumber winningNumber = getWinningNumberAndBonusNumber(winningNumbers, bonusNumber);

        LottoPrizeCount lottoPrizeCount = new LottoPrizeCount();
        printLottoResult(winningNumber, lottos, totalCost);
    }

    private int getLottoCost() {
        try {
            return InputView.totalCost();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getLottoCost();
        }
    }

    private Lottos generateLotto(int lottoCount) {
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
        OutputView.printLottoCount(lottoCount);
        OutputView.printLottos(lottos);
        return new Lottos(lottos);
    }

    private List<Integer> getWinningNumbers() {
        try {
            List<Integer> winningNumbers = InputView.winningNumber();
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getWinningNumbers();
        }
    }

    private int getBonnusNumber() {
        try {
            int bonusNumber = InputView.bonusNumber();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getBonnusNumber();
        }
    }

    private WinningNumber getWinningNumberAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }



    private void printLottoResult(WinningNumber winningNumber, Lottos lottos, int totalCost) {
        EnumMap<LottoPrize, Integer> prizeCounts = LottoPrizeCount.calculatePrizes(winningNumber, lottos);
        OutputView.printLottoResult(prizeCounts, totalCost);
    }
}
