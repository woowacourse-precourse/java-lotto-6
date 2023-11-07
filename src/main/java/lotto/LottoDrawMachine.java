package lotto;

import java.util.List;

import static lotto.CommandLine.showln;

public class LottoDrawMachine {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    private int totalLottoSize;
    private int threeMatches;
    private int fourMatches;
    private int fiveMatches;
    private int fiveAndBonusMatches;
    private int sixMatches;

    public void setup(
            List<Integer> winningNumbers,
            Integer bonusNumber
    ) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void draw(Lotto lotto) {
        countStatistics(
                countMatchingNumbers(lotto.getNumbers()),
                matchBounsNumber(lotto)
        );
    }

    private boolean matchBounsNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public void showResult() {
        showln("");
        showln("당첨 통계");
        showln("---");
        showln("3개 일치 (5,000원) - " + threeMatches + "개\n" +
                "4개 일치 (50,000원) - " + fourMatches + "개\n" +
                "5개 일치 (1,500,000원) - " + fiveMatches + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveAndBonusMatches + "개\n" +
                "6개 일치 (2,000,000,000원) - " + sixMatches + "개");
        showln("총 수익률은 " + calculateRateOfReturn() + "%입니다.");
    }

    private double calculateRateOfReturn() {
        return Math.round(((double) (calculateTotalPrize()) / (totalLottoSize * 1000) * 100.0) * 100) / 100.0;
    }

    private void countStatistics(
            int matchNumberCount,
            boolean isMatchBonusNumber
    ) {
        totalLottoSize++;
        if (matchNumberCount == 3) {
            threeMatches++;
        }
        if (matchNumberCount == 4) {
            fourMatches++;
        }
        if (matchNumberCount == 5) {
            fiveMatches++;
        }
        if (matchNumberCount == 5 && isMatchBonusNumber) {
            fiveAndBonusMatches++;
        }
        if (matchNumberCount == 6) {
            sixMatches++;
        }
    }

    private int countMatchingNumbers(
            List<Integer> lottoNumbers
    ) {
        int count = 0;
        for (Integer number : winningNumbers) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        if (lottoNumbers.contains(bonusNumber)) {
            count++;
        }
        return count;
    }

    private int calculateTotalPrize() {
        return ((threeMatches * 5000) +
                (fourMatches * 50000) +
                (fiveMatches * 1500000) +
                (fiveAndBonusMatches * 30000000) +
                (sixMatches * 2000000000));
    }


}
