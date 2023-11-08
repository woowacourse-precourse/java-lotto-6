package lotto.constants;

import java.text.DecimalFormat;

import static lotto.constants.Value.*;

public enum Rank {
    NO_RANK_ZERO(0, 0),
    NO_RANK_ONE(0, 0),
    NO_RANK_TWO(0, 0),
    FIFTH(3, LOTTO_5_RANK_PRIZE_MONEY),
    FOURTH(4, LOTTO_4_RANK_PRIZE_MONEY),
    THIRD(5, LOTTO_3_RANK_PRIZE_MONEY),
    FIRST(6, LOTTO_1_RANK_PRIZE_MONEY),
    SECOND(5, LOTTO_2_RANK_PRIZE_MONEY);

    private final int count;
    private final int prize;

    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        if (this == Rank.SECOND) {
            return count + "개 일치, 보너스 볼 일치 (" + decimalFormat.format(prize) + "원)";
        }
        return count + "개 일치 (" + decimalFormat.format(prize) + "원)";
    }


}
