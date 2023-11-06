package lotto.repository.rank;

import static lotto.settings.WinningAmount.FIFTH;
import static lotto.settings.WinningAmount.FIRST;
import static lotto.settings.WinningAmount.FOURTH;
import static lotto.settings.WinningAmount.SECOND;
import static lotto.settings.WinningAmount.THIRD;

import java.util.HashMap;
import java.util.Map;

public class AmountsPerRank {
    private static final Map<Integer, Integer> amountPerRank = new HashMap<>();

    public static void create(){
        amountPerRank.put(5,FIFTH.getIntPrize());
        amountPerRank.put(4,FOURTH.getIntPrize());
        amountPerRank.put(3,THIRD.getIntPrize());
        amountPerRank.put(2,SECOND.getIntPrize());
        amountPerRank.put(1,FIRST.getIntPrize());
    }

    public static Integer getAmountBy(int rank){
        return amountPerRank.get(rank);
    }
}
