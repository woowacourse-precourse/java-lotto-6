package lotto.constant;

import java.util.List;

public class LottoConstant {
    public static final int MAX_PURCHASE_AMOUNT = 100_000;

    public static final List<LotteryRank> LOTTERY_RANKS = List.of(
            LotteryRank.FIRST_PRIZE,
            LotteryRank.SECOND_PRIZE,
            LotteryRank.THIRD_PRIZE,
            LotteryRank.FOURTH_PRIZE,
            LotteryRank.FIFTH_PRIZE
    );
}
