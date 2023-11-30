package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoWinningCombination {
    List<Integer> winnerNums;
    int bonusNum;

    private LottoWinningCombination() {
    }

    public static LottoWinningCombination createLottoWinningCombination(List<Integer> winnerNums, int bonusNum) {
        LottoWinningCombination lottoWinningCombination = new LottoWinningCombination();
        lottoWinningCombination.winnerNums = winnerNums;
        lottoWinningCombination.bonusNum = bonusNum;

        return lottoWinningCombination;

    }
    public List<Integer> getWinnerNums() {
        return Collections.unmodifiableList(winnerNums);
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
