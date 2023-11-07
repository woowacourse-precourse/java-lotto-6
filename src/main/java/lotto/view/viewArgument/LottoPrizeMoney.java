package lotto.view.viewArgument;

import lotto.util.LottoConstants;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.util.LottoConstants.*;

public enum LottoPrizeMoney {
    FIFTH_GRADE(CORRECT_TREE, CORRECT_TREE_MONEY),
    FOURTH_GRADE(CORRECT_FOUR, CORRECT_FOUR_MONEY),
    THIRD_GRADE(CORRECT_FIVE, CORRECT_FIVE_MONEY),
    SECOND_GRADE(CORRECT_FIVE_WITH_BONUS, CORRECT_FIVE_WITH_BONUS_MONEY),
    FIRST_GRADE(CORRECT_SIX, CORRECT_SIX_MONEY);

    private final String correctCount;
    private final int prizeMoney;

    private LottoPrizeMoney(String correctCount, int prizeMoney) {
        this.correctCount = correctCount;
        this.prizeMoney = prizeMoney;
    }
    public String getCorrectCount() {
        return correctCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private static final Map<String, LottoPrizeMoney> getLottoPrizeMoney =
            Stream.of(values()).collect(Collectors.toMap(LottoPrizeMoney::getCorrectCount, Function.identity()));;

    public static LottoPrizeMoney valueOfCorrectCount(String correctCount) {
        return getLottoPrizeMoney.get(correctCount);
    }
}
