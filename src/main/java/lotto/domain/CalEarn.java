package lotto.domain;

import java.util.Map;

public class CalEarn {

    public static void CalEarn(Map<Ranking, Integer> result, Long price){

        double earn = 0;

        for (Ranking rank : result.keySet()) {
            int cnt = result.get(rank);
            earn += rank.getPrize() * cnt;
        }
        earn = (earn / price) * 100;

        Output.PrintEarning(earn);
    }
}
