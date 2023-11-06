package lotto.domain;

import java.util.List;

public class LottoCaclulator {

    public static double calculateRateOfReturn(List<Integer> winningCount, int money) {
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
