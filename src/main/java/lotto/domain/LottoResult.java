package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class LottoResult {

    private final List<Lotto> lottos;
    private int fivethPrizeCount = 0;
    private int fourthPrizeCount = 0;
    private int thirdPrizeCount = 0;
    private int secondPrizeCount = 0;
    private int firstPrizeCount = 0;

    public LottoResult(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void configurePrizeCount(List<Integer> winningNumbers) {
        for (Lotto lotto : this.lottos) {
            int matchedCount = lotto.compareWinningNumbers(winningNumbers);

            if (checkWinning(matchedCount)) {
                compareBonusNumber(lotto, winningNumbers.get(6));
            }
        }
    }

    public void printWinningHistory() {
        System.out.print("\n당첨 통계\n---\n");
        System.out.print("3개 일치 (5,000원) - " + this.fivethPrizeCount + "개\n");
        System.out.print("4개 일치 (50,000원) - " + this.fourthPrizeCount + "개\n");
        System.out.print("5개 일치 (1,500,000원) - " + this.thirdPrizeCount + "개\n");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - " + this.secondPrizeCount + "개\n");
        System.out.print("6개 일치 (2,000,000,000원) - " + this.firstPrizeCount + "개\n");
    }

    private boolean checkWinning(int matchedCount) {
        if (matchedCount == 3) {
            this.fivethPrizeCount++;
        }
        if (matchedCount == 4) {
            this.fourthPrizeCount++;
        }
        if (matchedCount == 5) {
            this.thirdPrizeCount++;
        }

        return matchedCount == 6;
    }

    private void compareBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.compareNumber(bonusNumber)) {
            this.secondPrizeCount++;
        }

        this.firstPrizeCount++;
    }
}
