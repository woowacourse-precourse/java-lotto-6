package lotto;

import java.util.HashMap;
import java.util.Map;

import static lotto.LottoWinningStatus.*;

public class LottoResultStore {
    private final Map<Integer, Integer> lottoResultStore = new HashMap<>();

    public void resetLottoResultStore() {
        for (LottoWinningStatus status : LottoWinningStatus.values()) {
            lottoResultStore.put(status.getRewardMoney(), 0);
        }
    }

    public void checkLottoRank(int winningNumberMatch, int bonusNumberMatch) {
        if (winningNumberMatch == 3)
            lottoResultStore.put(FIFTH_AWARD.getRewardMoney(), lottoResultStore.get(FIFTH_AWARD.getRewardMoney()) + 1);
        if (winningNumberMatch == 4)
            lottoResultStore.put(FOURTH_AWARD.getRewardMoney(), lottoResultStore.get(FOURTH_AWARD.getRewardMoney()) + 1);
        if (winningNumberMatch == 5)
            lottoResultStore.put(THIRD_AWARD.getRewardMoney(), lottoResultStore.get(THIRD_AWARD.getRewardMoney()) + 1);
        if (winningNumberMatch == 5 && bonusNumberMatch == 1)
            lottoResultStore.put(SECOND_AWARD.getRewardMoney(), lottoResultStore.get(SECOND_AWARD.getRewardMoney()) + 1);
        if (winningNumberMatch == 6)
            lottoResultStore.put(FIRST_AWARD.getRewardMoney(), lottoResultStore.get(FIRST_AWARD.getRewardMoney()) + 1);
    }

    public Map<Integer, Integer> getLottoResultStore() {
        return lottoResultStore;
    }
}
