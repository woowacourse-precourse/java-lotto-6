package lotto.model;

import java.util.Map;

public class Constants {
    public final static int LOTTO_PRICE = 1000;
    public final static int LOTTO_NUMBER_COUNT = 6;
    public final static int LOTTO_RANGE_START = 1;
    public final static int LOTTO_RANGE_END = 45;
    public final static int PRIZE_COUNT = 5;

    public final static Map<PRIZE_TYPE, Integer> PRIZE_MONEY = Map.of(
            PRIZE_TYPE.FIRST, 2_000_000_000, // 20억
            PRIZE_TYPE.SECOND, 30_000_000, // 3000만
            PRIZE_TYPE.THIRD, 1_500_000, // 150만
            PRIZE_TYPE.FOURTH, 50_000, // 5만
            PRIZE_TYPE.FIVETH, 5_000, // 5천
            PRIZE_TYPE.NONE, 0
    );

    public final static Map<Integer, PRIZE_TYPE> PRIZE_CONDITION = Map.of(
            0,PRIZE_TYPE.NONE,
            1,PRIZE_TYPE.NONE,
            2,PRIZE_TYPE.NONE,
            3,PRIZE_TYPE.FIVETH,
            4,PRIZE_TYPE.FOURTH,
            5,PRIZE_TYPE.THIRD,
            6,PRIZE_TYPE.SECOND,
            7,PRIZE_TYPE.FIRST
    );
}
