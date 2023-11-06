package lotto.domain;

import lotto.constant.LottoRank;

import java.util.HashMap;
import java.util.Map;

public class LottoPrize {
    LottoRank lottoRank;

    public Map<Integer, Map<String, Integer>> initLottoPrize() {
        Map<Integer, Map<String, Integer>> lottoPrize = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            int winCount = lottoRank.getWinningCount();

            if(winCount == 5) continue;
            lottoPrize.put(winCount, bonusValue(winCount, lottoRank.getBonus()));
        }
        lottoPrize.put(5, doubleValue());
        return lottoPrize;
    }

    public Map<String, Integer> doubleValue() {
        Map<String, Integer> doubleMap = new HashMap<>();
        doubleMap.put(lottoRank.SECOND.getWinningCount()+lottoRank.SECOND.getBonus(), 0);
        doubleMap.put(lottoRank.THIRD.getWinningCount()+lottoRank.THIRD.getBonus(), 0);

        return doubleMap;
    }

    public Map<String, Integer> bonusValue(int winCount, String checkBonus) {
        Map<String, Integer> bonus = new HashMap<>();
        String bonusKey = winCount + checkBonus;
        bonus.put(bonusKey, 0);
        return bonus;
    }
}
