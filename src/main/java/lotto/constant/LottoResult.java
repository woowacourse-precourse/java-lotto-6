package lotto.constant;

import static lotto.constant.LottoConstant.*;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoResult {

    OUT_OF_BOUND_NO_MATCH(0, (count) -> OUT_OF_BOUND_AMOUNT),
    OUT_OF_BOUND_ONE_MATCH(1, (count) -> OUT_OF_BOUND_AMOUNT),
    OUT_OF_BOUND_TWO_MATCH(2, (count) -> OUT_OF_BOUND_AMOUNT),
    FIFTH_PLACE(3, (count) -> count * FIFTH_PLACE_AMOUNT),
    FOURTH_PLACE(4, (count) -> count * FOURTH_PLACE_AMOUNT),
    THIRD_PLACE(5, (count) -> count * THIRD_PLACE_AMOUNT),
    SECOND_PLACE(5, (count) -> count * SECOND_PLACE_AMOUNT),
    FIRST_PLACE(6, (count) -> count * FIRST_PLACE_AMOUNT);

    private final int matchCount;
    private final Function<Integer, Long> calculateAmount;

    LottoResult(int matchCount, Function<Integer, Long> calculateAmount) {
        this.matchCount = matchCount;
        this.calculateAmount = calculateAmount;
    }

    public static LottoResult valueOfMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findAny()
                .orElse(null);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long calculateLottoAmount(int count) {
        return calculateAmount.apply(count);
    }
}
