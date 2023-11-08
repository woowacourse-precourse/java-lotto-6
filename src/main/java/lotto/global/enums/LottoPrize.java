package lotto.global.enums;

import java.util.Arrays;

public enum LottoPrize {

    FIRST_PRIZE(ViewMessage.OUTPUT_FIRST_PRIZE, 6, 0, 2000000000),
    SECOND_PRIZE(ViewMessage.OUTPUT_SECOND_PRIZE, 5, 1, 30000000),
    THIRD_PRIZE(ViewMessage.OUTPUT_THIRD_PRIZE, 5, 0, 1500000),
    FOURTH_PRIZE(ViewMessage.OUTPUT_FOURTH_PRIZE, 4, 0, 50000),
    FIFTH_PRIZE(ViewMessage.OUTPUT_FIFTH_PRIZE, 3, 0, 5000),
    NONE(null, 2, 0, 0);

    private ViewMessage viewMessage;
    private int normalNumberCondition;
    private int bonusNumberCondition;
    private int prize;

    LottoPrize(ViewMessage viewMessage, int normalNumberCondition, int bonusNumberCondition, int prize){
        this.viewMessage = viewMessage;
        this.normalNumberCondition = normalNumberCondition;
        this.bonusNumberCondition = bonusNumberCondition;
        this.prize = prize;
    }
    public static LottoPrize determinePrize(final int normalNumberCount, final int bonusNumberCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> normalNumberCount == prize.normalNumberCondition)
                .filter(prize -> bonusNumberCount == 0 || prize.bonusNumberCondition == bonusNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize(){
        return this.prize;
    }

    public String getViewMessage(){
        return this.viewMessage.getMessage();
    }
}
