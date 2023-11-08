package lotto.domain;

import lotto.util.Constants;
import lotto.view.OutputView;

import java.text.DecimalFormat;
import java.util.List;

public class LottoPrize {
    private List<Lotto> purchasedLotto;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoPrize(List<Lotto> purchasedLotto, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLotto = purchasedLotto;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void calculatePrizes() {
        int[] prizeCounts = new int[7];

        for (Lotto lotto : purchasedLotto) {
            int matchCount = countMatchingNumbers(lotto);
            LottoMatch match = LottoMatch.findByMatchCount(matchCount, lotto.getNumbers().contains(bonusNumber));
            prizeCounts[match.ordinal()]++;
        }

        printPrizes(prizeCounts);
        printRate(calculateRate(prizeCounts));
    }
    private void printPrizes(int[] prizeCounts) {
        OutputView.lottoResult();
        for (LottoMatch match : LottoMatch.values()) {
            if (match != LottoMatch.MISS) {
                System.out.println(match.getResultMessage() + prizeCounts[match.ordinal()] + "개");
            }
        }
    }
    private double calculateRate(int[] prizeCount) {
        // 총 수익률 계산
        double totalPrize = calculateTotalPrize(prizeCount);
        double purchaseCost = purchasedLotto.size() * Constants.LOTTO_PRICE;
        return (totalPrize / purchaseCost) * 100.0;
    }

    private void printRate(double earningRate) {
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.printf(Constants.END_RESULT, df.format(earningRate));

    }
    private int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
    private double calculateTotalPrize(int[] prizeCounts) {
        double totalPrize = 0;
        for (int i = 3; i <= 6; i++) {
            totalPrize += prizeCounts[i] * Constants.PRIZE_MONEY[i];
        }
        totalPrize += prizeCounts[2] * Constants.PRIZE_MONEY[2];
        totalPrize += prizeCounts[5] * Constants.PRIZE_MONEY[5];
        return totalPrize;
    }
}
