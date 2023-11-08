package lotto;

import java.util.Arrays;
import java.util.List;

enum LottoEnum {
    NUMBER_MIN(1),
    NUMBER_MAX(45),
    SIZE(6),
    PRICE(1000),
    NORMAL_BALL_SCORE(10),
    BONUS_BALL_SCORE(1),
    PRIZE_LAST_MONEY(0),
    PRIZE_5TH_NORMAL_BALL_HIT(3),
    PRIZE_5TH_SCORE(PRIZE_5TH_NORMAL_BALL_HIT.value * NORMAL_BALL_SCORE.value),
    PRIZE_5TH_MONEY(5000),

    PRIZE_4TH_NORMAL_BALL_HIT(4),
    PRIZE_4TH_SCORE(PRIZE_4TH_NORMAL_BALL_HIT.value * NORMAL_BALL_SCORE.value),
    PRIZE_4TH_MONEY(50000),

    PRIZE_3RD_NORMAL_BALL_HIT(5),
    PRIZE_3RD_SCORE(PRIZE_3RD_NORMAL_BALL_HIT.value * NORMAL_BALL_SCORE.value),
    PRIZE_3RD_MONEY(1500000),

    PRIZE_2ND_NORMAL_BALL_HIT(5),
    PRIZE_2ND_SCORE(PRIZE_2ND_NORMAL_BALL_HIT.value * NORMAL_BALL_SCORE.value + BONUS_BALL_SCORE.value),
    PRIZE_2ND_MONEY(30000000),

    PRIZE_1ST_NORMAL_BALL_HIT(6),
    PRIZE_1ST_SCORE(PRIZE_1ST_NORMAL_BALL_HIT.value * NORMAL_BALL_SCORE.value),
    PRIZE_1ST_MONEY(2000000000);

    private final int value;
    public static final List<Integer> normalBallHitted = Arrays.asList(
            LottoEnum.PRIZE_5TH_NORMAL_BALL_HIT.getValue(),
            LottoEnum.PRIZE_4TH_NORMAL_BALL_HIT.getValue(),
            LottoEnum.PRIZE_3RD_NORMAL_BALL_HIT.getValue(),
            LottoEnum.PRIZE_2ND_NORMAL_BALL_HIT.getValue(),
            LottoEnum.PRIZE_1ST_NORMAL_BALL_HIT.getValue());
    public static final List<Integer> prize = Arrays.asList(
            LottoEnum.PRIZE_5TH_MONEY.getValue(),
            LottoEnum.PRIZE_4TH_MONEY.getValue(),
            LottoEnum.PRIZE_3RD_MONEY.getValue(),
            LottoEnum.PRIZE_2ND_MONEY.getValue(),
            LottoEnum.PRIZE_1ST_MONEY.getValue());
    public static final List<Integer> prizeScores = Arrays.asList(
            LottoEnum.PRIZE_5TH_SCORE.getValue(),
            LottoEnum.PRIZE_4TH_SCORE.getValue(),
            LottoEnum.PRIZE_3RD_SCORE.getValue(),
            LottoEnum.PRIZE_2ND_SCORE.getValue(),
            LottoEnum.PRIZE_1ST_SCORE.getValue());

    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}