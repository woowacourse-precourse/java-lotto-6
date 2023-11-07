package lotto.global.enums;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoPrize {

    FIRST_PRIZE(ViewMessage.OUTPUT_FIRST_PRIZE, 6, 0),
    SECOND_PRIZE(ViewMessage.OUTPUT_SECOND_PRIZE, 5, 1),
    THIRD_PRIZE(ViewMessage.OUTPUT_THIRD_PRIZE, 5, 0),
    FOURTH_PRIZE(ViewMessage.OUTPUT_FOURTH_PRIZE, 4, 0),
    FIFTH_PRIZE(ViewMessage.OUTPUT_FIFTH_PRIZE, 3, 0),
    NONE(null, 2, 0);
    ;

    private ViewMessage viewMessage;
    private int normalNumberCondition;
    private int bonusNumberCondition;

    LottoPrize(ViewMessage viewMessage, int normalNumberCondition, int bonusNumberCondition){
        this.viewMessage = viewMessage;
        this.normalNumberCondition = normalNumberCondition;
        this.bonusNumberCondition = bonusNumberCondition;
    }
    public static LottoPrize determinePrize(final int normalNumberCount, final int bonusNumberCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> normalNumberCount == prize.normalNumberCondition)
                .filter(prize -> bonusNumberCount == 0 || prize.bonusNumberCondition == bonusNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public String getViewMessage(){
        return this.viewMessage.getMessage();
    }
}
