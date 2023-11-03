package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
        OutputView.displayPurchaseGuide();

        final Amount amount = inputLottoAmount();
        OutputView.displayLottoCount(amount.getAmount() / 1000);

        final List<Lotto> lottoList = buyLotto(amount.getAmount() / 1000);
        OutputView.displayLottoNumbers(lottoList);

        OutputView.displayWinningNumberGuide();
        final WinningLotto winningLotto = inputWinningNumbers();

        OutputView.displayBonusNumberGuide();
        final BonusNumber bonusNumber = inputBonusNumber();

        final List<LottoMatch> lottoResultCount = compareWinningNumbers(amount.getAmount() / 1000, lottoList, winningLotto, bonusNumber);
        final int winningAmount = calculateWinnings(lottoResultCount);

        OutputView.displayWinningStatisticsGuide();
        OutputView.displayWinningStatistics(lottoResultCount);

        double yield = calculateYield(winningAmount, Double.valueOf(amount.getAmount()));
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

    private WinningLotto inputWinningNumbers() {
        List<String> winningNumbers;
        WinningLotto winningLotto;
        while (true) {
            try {
                winningNumbers = InputView.inputWinningNumbers();
                winningLotto = new WinningLotto(winningNumbers);
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

    private List<LottoMatch> compareWinningNumbers(int lottoCount, List<Lotto> lottoList, WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<LottoMatch> lottoMatches = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = lottoList.get(i).getNumbers();
            int count = 0;
            for (int k = 0; k < 6; k++) {
                if (winningLotto.getNumbers().contains(lottoNumbers.get(k))) {
                    count++;
                }
            }
            lottoMatches.add(LottoMatch.collect(count, lottoNumbers.contains(bonusNumber.getBonusNumber())));
        }
        return lottoMatches;
    }

    private int calculateWinnings(List<LottoMatch> lottoResultCount) {
        int winningAmount = 0;

        for (LottoMatch lottoMatch : lottoResultCount) {
            winningAmount += lottoMatch.getAmount();
        }

        return winningAmount;
    }

    private Double calculateYield(int winningAmount, Double amount) {
        return winningAmount / amount * 100;
    }
}
