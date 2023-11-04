package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    public void run() {
        OutputView.displayPurchaseGuide();

        final Amount amount = inputLottoAmount();
        final List<Lotto> lottoList = buyLotto(LottoGameManager.calculateLottoCount(amount));
        OutputView.displayLottoNumbers(lottoList);

        OutputView.displayWinningNumberGuide();
        final WinningLotto winningLotto = inputWinningNumbers();

        OutputView.displayBonusNumberGuide();
        final BonusNumber bonusNumber = inputBonusNumber();

        final List<LottoMatch> matchedResults = calculateMatches(lottoList, winningLotto, bonusNumber);

        OutputView.displayWinningStatisticsGuide();
        OutputView.displayWinningStatistics(matchedResults);

        double yield = calculateYield(calculateWinnings(matchedResults), Double.valueOf(amount.getAmount()));
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
        OutputView.displayLottoCount(lottoCount);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    private WinningLotto inputWinningNumbers() {
        WinningLotto winningLotto;
        while (true) {
            try {
                winningLotto = new WinningLotto(InputView.inputWinningNumbers());
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

    private List<LottoMatch> calculateMatches(List<Lotto> lottoList, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .map(lottoNumbers -> {
                    long count = lottoNumbers.stream()
                            .filter(winningLotto.getNumbers()::contains)
                            .count();
                    boolean hasBonusNumber = lottoNumbers.contains(bonusNumber.getBonusNumber());
                    return LottoMatch.collect((int) count, hasBonusNumber);
                })
                .collect(Collectors.toList());
    }

    private int calculateWinnings(List<LottoMatch> lottoResultCount) {
        return lottoResultCount.stream()
                .mapToInt(LottoMatch::getAmount)
                .sum();
    }

    private Double calculateYield(int winningAmount, Double amount) {
        return winningAmount / amount * 100;
    }
}
