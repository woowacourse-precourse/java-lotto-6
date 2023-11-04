package lotto;

import java.util.List;

public class LottoResult {

    private final LottoComparator comparator = new LottoComparator();

    private Integer matchesThree;
    private Integer matchesFour;
    private Integer matchFive;
    private Integer matchFiveAndBonus;
    private Integer matchSix;
    private Float rateOfReturn;

    public LottoResult() {
        this.matchesThree = 0;
        this.matchesFour = 0;
        this.matchFive = 0;
        this.matchFiveAndBonus = 0;
        this.matchSix = 0;
        this.rateOfReturn = 0.0F;
    }

    public LottoResult showLottoResult(List<Integer> winningNumbers, Integer bonus, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> result = comparator.compareLotto(winningNumbers, bonus, lotto);
            saveResult(result);
        }
        calculateRateOfReturn(lottos.size());
        return this;
    }

    private void calculateRateOfReturn(int size) {
        int userInputMoney = size * 1000;
        this.rateOfReturn += (matchesThree * 5000);
        this.rateOfReturn += (matchesFour * 50000);
        this.rateOfReturn += (matchFive * 1500000);
        this.rateOfReturn += (matchFiveAndBonus * 30000000);
        this.rateOfReturn += (matchSix * 2000000000);
        this.rateOfReturn = this.rateOfReturn / userInputMoney * 100;
    }

    private void saveResult(List<Integer> result) {
        Integer winningNumberMatchCount = result.get(0);
        Integer bonusMatchCount = result.get(1);

        if (winningNumberMatchCount == 3) {
            matchesThree++;
        } else if (winningNumberMatchCount == 4) {
            matchesFour++;
        } else if (winningNumberMatchCount == 5 && bonusMatchCount == 1) {
            matchFiveAndBonus++;
        } else if (winningNumberMatchCount == 5 && bonusMatchCount == 0) {
            matchFive++;
        } else if (winningNumberMatchCount == 6) {
            matchSix++;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "3개 일치 (5,000원) - %d개\n" +
                        "4개 일치 (50,000원) - %d개\n" +
                        "5개 일치 (1,500,000원) - %d개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                        "6개 일치 (2,000,000,000원) - %d개\n" +
                        "총 수익률은 %.1f%%입니다.",
                this.matchesThree, this.matchesFour, this.matchFive, this.matchFiveAndBonus, this.matchSix, this.rateOfReturn
        );
    }

}
