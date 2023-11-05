package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoPrize {

    final String bonusOff = "NoBonus";

    final String fiveBonusOn = "5Bonus";
    final String fiveBonusOff = "5NoBonus";


    public Map<Integer, Map<String, Integer>> initLottoPrize() {
        Map<Integer, Map<String, Integer>> lottoPrize = new HashMap<>();

        for (int winCount = 3; winCount <= 6; winCount++) {
            if (winCount == 5) {
                Map<String, Integer> hasBonus = new HashMap<>();
                lottoPrize.put(winCount, hasBonus);

                hasBonus.put(fiveBonusOn, 0);
                hasBonus.put(fiveBonusOff, 0);
                continue;
            }
            lottoPrize.put(winCount, innerMap(winCount, bonusOff, 0));
        }

        return lottoPrize;
    }

    public Map<String, Integer> innerMap(int winCount, String bonusCheck, int count) {
        StringBuilder key = new StringBuilder();
        key.append(winCount).append(bonusCheck);
        Map<String, Integer> bonus = new HashMap<>();
        bonus.put(key.toString(), count);
        return bonus;
    }
}
