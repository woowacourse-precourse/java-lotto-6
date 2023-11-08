package lotto.enums;

import static lotto.enums.OutputMessageEnum.OUTPUT_FIVE_AND_BONUS_SAME_MESSAGE;
import static lotto.enums.OutputMessageEnum.OUTPUT_FIVE_SAME_MESSAGE;
import static lotto.enums.OutputMessageEnum.OUTPUT_FOUR_SAME_MESSAGE;
import static lotto.enums.OutputMessageEnum.OUTPUT_NOTHING_SAME_MESSAGE;
import static lotto.enums.OutputMessageEnum.OUTPUT_SIX_SAME_MESSAGE;
import static lotto.enums.OutputMessageEnum.OUTPUT_THREE_SAME_MESSAGE;

public enum LottoRankEnum {

    FIFTH(3, false, 5000, OUTPUT_THREE_SAME_MESSAGE),
    FOURTH(4, false, 50000, OUTPUT_FOUR_SAME_MESSAGE),
    THIRD(5, false, 1500000, OUTPUT_FIVE_SAME_MESSAGE),
    SECOND(5, true, 30000000, OUTPUT_FIVE_AND_BONUS_SAME_MESSAGE),
    FIRST(6, false, 2000000000, OUTPUT_SIX_SAME_MESSAGE),
    NOTHING(0, false, 0, OUTPUT_NOTHING_SAME_MESSAGE);

    private final int sameCount;
    private final boolean containsBonus;
    private final int prize;
    private final OutputMessageEnum outputMessageEnum;

    LottoRankEnum(int sameCount, boolean containsBonus, int prize, OutputMessageEnum outputMessageEnum) {
        this.sameCount = sameCount;
        this.containsBonus = containsBonus;
        this.prize = prize;
        this.outputMessageEnum = outputMessageEnum;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isContainsBonus() {
        return containsBonus;
    }

    public int getPrize() {
        return prize;
    }

    public OutputMessageEnum getOutputMessageEnum() {
        return outputMessageEnum;
    }
}
