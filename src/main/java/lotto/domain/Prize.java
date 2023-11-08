package lotto.domain;

import java.util.Arrays;
import lotto.constant.Condition;
import lotto.constant.Message;

public enum Prize {
    NO_PRIZE(0, 0, null, false, Condition.ZERO),
    FIFTH_PRIZE(1, 3, Message.FIFTH_PRIZE, false, Condition.FIFTH_PRIZE_AMOUNT),
    FOURTH_PRIZE(2, 4, Message.FOURTH_PRIZE, false, Condition.FOURTH_PRIZE_AMOUNT),
    THIRD_PRIZE(3, 5, Message.THIRD_PRIZE, false, Condition.THIRD_PRIZE_AMOUNT),
    SECOND_PRIZE(4, 5, Message.SECOND_PRIZE, true, Condition.SECOND_PRIZE_AMOUNT),
    FIRST_PRIZE(5, 6, Message.FIRST_PRIZE, false, Condition.FIRST_PRIZE_AMOUNT);

    private final int INDEX;
    private final int MATCH_NUMBERS;
    private final String PRIZE_MESSAGE;
    private final boolean COMPARE_BONUS_NUMBER;
    private final int PRIZE_AMOUNT;

    Prize(int INDEX, int MATCH_NUMBERS, String PRIZE_MESSAGE, boolean COMPARE_BONUS_NUMBER, int PRIZE_AMOUNT) {
        this.INDEX = INDEX;
        this.MATCH_NUMBERS = MATCH_NUMBERS;
        this.PRIZE_MESSAGE = PRIZE_MESSAGE;
        this.COMPARE_BONUS_NUMBER = COMPARE_BONUS_NUMBER;
        this.PRIZE_AMOUNT = PRIZE_AMOUNT;
    }

    public int checkPrize(int mathNumbers, boolean matchBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.MATCH_NUMBERS == mathNumbers)
                .filter(prize -> prize.COMPARE_BONUS_NUMBER == matchBonusNumber)
                .findFirst()
                .orElse(NO_PRIZE).ordinal();
    }

    private Prize findPrizeByIndex(int idx){
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.ordinal() == idx)
                .findFirst().get();
    }

    public String getPrizeInfo(int idx){
        StringBuilder info = new StringBuilder();
        Prize current = findPrizeByIndex(idx);
        info.append(current.PRIZE_MESSAGE)
                .append("(")
                .append(current.PRIZE_AMOUNT)
                .append("원) - ");
        return info.toString();
    }

}
