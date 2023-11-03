package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.model.Amount;
import lotto.model.BonusNumber;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public void run() {
        outputView.displayPurchaseGuide();
        int amount;

        while (true) {
            try {
                amount = Amount.create(inputView.inputPurchaseAmount()).getAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int lottoCount = amount / 1000;
        outputView.displayLottoCount(lottoCount);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        outputView.displayLottoNumbers(lottoList);

        outputView.displayWinningNumberGuide();
        List<Integer> winningNumbers;
        Lotto winningLotto;

        while (true) {
            try {
                winningNumbers = inputView.inputWinningNumbers();
                winningLotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        outputView.displayBonusNumberGuide();
        BonusNumber bonusNumber;

        while (true) {
            try {
                bonusNumber = BonusNumber.create(inputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int[] lottoResultCount = new int[5];
        double winningAmount = 0;

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
                winningAmount += 50000;
                continue;
            }
            if (count == 5 && lottoNumbers.contains(bonusNumber.getBonusNumber())) {
                lottoResultCount[3]++;
                winningAmount += 30000000;
                continue;
            }
            if (count == 5) {
                lottoResultCount[2]++;
                winningAmount += 1500000;
                continue;
            }
            if (count == 4) {
                lottoResultCount[1]++;
                winningAmount += 50000;
                continue;
            }
            if (count == 3) {
                lottoResultCount[0]++;
                winningAmount += 5000;
            }
        }

        outputView.displayWinningStatisticsGuide();
        outputView.displayWinningStatistics(lottoResultCount);
        double yield = winningAmount / Double.valueOf(amount) * 100;
        outputView.displayYield(yield);
    }
}
