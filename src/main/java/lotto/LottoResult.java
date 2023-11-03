package lotto;

import java.util.List;

public class LottoResult {

    private final LottoComparator comparator = new LottoComparator();

    private Integer matchesThree;
    private Integer matchesFour;
    private Integer matchFive;
    private Integer matchFiveAndBonus;
    private Integer matchSix;

    public LottoResult() {
        this.matchesThree = 0;
        this.matchesFour = 0;
        this.matchFive = 0;
        this.matchFiveAndBonus = 0;
        this.matchSix = 0;
    }

    public LottoResult showLottoResult(List<String> winningNumbers, Integer bonus, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> result = comparator.compareLotto(winningNumbers, bonus, lotto);
            saveResult(result);
        }
        return this;
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
}
