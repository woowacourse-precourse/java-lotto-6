package lotto.Model;

import lotto.validation.Validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinningLotto {

    private static final int LOTTO_PRICE = 1000;
    private final HashMap<Rank, Integer> winningCount;
    private double totalPrizeMoney;

    public WinningLotto() {
        winningCount = new HashMap<>() {{
            put(Rank.FIRST, 0);
            put(Rank.SECOND, 0);
            put(Rank.THIRD, 0);
            put(Rank.FOURTH, 0);
            put(Rank.FIFTH, 0);
            put(Rank.MISS, 0);
        }};
        totalPrizeMoney = 0;
    }




}
