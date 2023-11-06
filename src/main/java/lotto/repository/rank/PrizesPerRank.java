package lotto.repository.rank;

import static lotto.settings.WinningAmount.FIFTH;
import static lotto.settings.WinningAmount.FIRST;
import static lotto.settings.WinningAmount.FOURTH;
import static lotto.settings.WinningAmount.SECOND;
import static lotto.settings.WinningAmount.THIRD;

import java.util.HashMap;
import java.util.Map;

public class PrizesPerRank {
    private static final Map<Integer, Integer> prizePerRank = new HashMap<>();

    public static void create(){
        prizePerRank.put(5,FIFTH.getIntPrize());
        prizePerRank.put(4,FOURTH.getIntPrize());
        prizePerRank.put(3,THIRD.getIntPrize());
        prizePerRank.put(2,SECOND.getIntPrize());
        prizePerRank.put(1,FIRST.getIntPrize());
    }

    public static Integer getPrizeBy(int rank){
        return prizePerRank.get(rank);
    }
}
