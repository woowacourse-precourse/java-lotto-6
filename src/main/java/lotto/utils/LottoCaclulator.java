package lotto.utils;

import java.util.List;
import lotto.domain.MatchNumber;

public class LottoCaclulator {

    public static double calculateRateOfReturn(final List<Integer> winningCount, final int money) {
        double sum = 0;
        int i = 0;
        for (MatchNumber match : MatchNumber.getMembers()) {
            int repeat = winningCount.get(i);
            sum += (match.getMoney() * repeat);
            i++;
        }
        return sum / money;
    }
}
