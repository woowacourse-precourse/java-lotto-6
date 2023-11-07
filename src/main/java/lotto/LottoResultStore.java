package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultStore {
    private static final int FIFTH_AWARD_REWARD_MONEY = 5_000;
    private static final int FOURTH_AWARD_REWARD_MONEY = 50_000;
    private static final int THIRD_AWARD_REWARD_MONEY = 1_500_000;
    private static final int SECOND_AWARD_REWARD_MONEY = 30_000_000;
    private static final int FIRST_AWARD_REWARD_MONEY = 2_000_000_000;
    private final Map<Integer, Integer> lottoResultStore = new HashMap<>();

    public void resetLottoResultStore() {
        for (LottoWinningStatus status : LottoWinningStatus.values()) {
            lottoResultStore.put(status.getRewardMoney(), 0);
        }
    }

    public void checkLottoRank(int winningNumberMatch, int bonusNumberMatch) {
        if (winningNumberMatch == 3)
            lottoResultStore.put(FIFTH_AWARD_REWARD_MONEY, lottoResultStore.get(FIFTH_AWARD_REWARD_MONEY) + 1);
        if (winningNumberMatch == 4)
            lottoResultStore.put(FOURTH_AWARD_REWARD_MONEY, lottoResultStore.get(FOURTH_AWARD_REWARD_MONEY) + 1);
        if (winningNumberMatch == 5)
            lottoResultStore.put(THIRD_AWARD_REWARD_MONEY, lottoResultStore.get(THIRD_AWARD_REWARD_MONEY) + 1);
        if (winningNumberMatch == 5 && bonusNumberMatch == 1)
            lottoResultStore.put(SECOND_AWARD_REWARD_MONEY, lottoResultStore.get(SECOND_AWARD_REWARD_MONEY) + 1);
        if (winningNumberMatch == 6)
            lottoResultStore.put(FIRST_AWARD_REWARD_MONEY, lottoResultStore.get(FIRST_AWARD_REWARD_MONEY) + 1);
    }

    public Map<Integer, Integer> getLottoResultStore() {
        return lottoResultStore;
    }
}

