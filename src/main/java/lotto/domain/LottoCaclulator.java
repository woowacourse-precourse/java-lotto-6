package lotto.domain;

import java.util.List;

public class LottoCaclulator {
    public static float calculateRateOfReturn(List<MatchNumber> winningCount, int money) {
        float sum = winningCount.stream().mapToInt(matchNumber -> matchNumber.getMoney()).sum();
        return sum / money;
    }
}
