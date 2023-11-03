package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Amount;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
        OutputView.displayPurchaseGuide();

        final Amount lottoCount = inputLottoAmount();
        OutputView.displayLottoCount(lottoCount.getAmount());

        final List<Lotto> lottoList = buyLotto(lottoCount.getAmount());
        OutputView.displayLottoNumbers(lottoList);

        OutputView.displayWinningNumberGuide();
        final Lotto winningLotto = inputWinningNumbers();

        OutputView.displayBonusNumberGuide();
        final BonusNumber bonusNumber = inputBonusNumber();

        final int[] lottoResultCount = compareWinningNumbers(lottoCount.getAmount(), lottoList, winningLotto, bonusNumber);
        final int winningAmount = calculateWinnings(lottoResultCount);

        OutputView.displayWinningStatisticsGuide();
        OutputView.displayWinningStatistics(lottoResultCount);

        double yield = calculateYield(winningAmount, lottoCount.getAmount());
        OutputView.displayYield(yield);
    }

    private Amount inputLottoAmount() {
        Amount amount;

        while (true) {
            try {
                amount = Amount.create(InputView.inputPurchaseAmount());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    private List<Lotto> buyLotto(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoList;
    }

    private Lotto inputWinningNumbers() {
        List<Integer> winningNumbers;
        Lotto winningLotto;
        while (true) {
            try {
                winningNumbers = InputView.inputWinningNumbers();
                winningLotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    private BonusNumber inputBonusNumber() {
        BonusNumber bonusNumber;
        while (true) {
            try {
                bonusNumber = BonusNumber.create(InputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private int[] compareWinningNumbers(int lottoCount, List<Lotto> lottoList, Lotto winningLotto, BonusNumber bonusNumber) {
        int[] lottoResultCount = new int[5];

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = lottoList.get(i).getNumbers();
            int count = 0;
            for (int k = 0; k < 6; k++) {
                if (winningLotto.getNumbers().contains(lottoNumbers.get(k))) {
                    count++;
                }
            }
            if (count == 6) {
                lottoResultCount[4]++;
                continue;
            }
            if (count == 5 && lottoNumbers.contains(bonusNumber.getBonusNumber())) {
                lottoResultCount[3]++;
                continue;
            }
            if (count == 5) {
                lottoResultCount[2]++;
                continue;
            }
            if (count == 4) {
                lottoResultCount[1]++;
                continue;
            }
            if (count == 3) {
                lottoResultCount[0]++;
            }
        }
        return lottoResultCount;
    }

    private int calculateWinnings(int[] lottoResultCount) {
        int winningAmount = 0;

        winningAmount += lottoResultCount[0] * 5000;
        winningAmount += lottoResultCount[1] * 50000;
        winningAmount += lottoResultCount[2] * 1500000;
        winningAmount += lottoResultCount[3] * 30000000;
        winningAmount += lottoResultCount[4] * 2000000000;

        return winningAmount;
    }

    private Double calculateYield(int winningAmount, int lottoCount) {
        return winningAmount / (lottoCount * 1000.0) * 100;
    }
}
