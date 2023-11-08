package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Result {

    SIX(6, BonusType.UNMATCHED, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    BONUS(5, BonusType.MATCH, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIVE(5, BonusType.UNMATCHED, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOUR(4, BonusType.DONT_CARE, 50_000, "4개 일치 (50,000원) - "),
    THREE(3, BonusType.DONT_CARE, 5_000, "3개 일치 (5,000원) - "),
    FAIL();

    private int matchCount;
    private BonusType isMatch;
    private int prize;
    private String message;

    Result(int matchCount, BonusType isMatch, int prize, String message) {
        this.matchCount = matchCount;
        this.isMatch = isMatch;
        this.prize = prize;
        this.message = message;
    }

    Result() {
    }

    public int getPrize() {
        return prize;
    }

    public static Map<Result, Integer> getBaseMap() {
        return Arrays.stream(Result.values())
                .collect(Collectors.toMap(
                        Function.identity(), value -> 0, Integer::sum));
    }

    public static Result checkResult(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(result -> result.matchCount == matchCount)
                .map(result -> findResult(result, matchCount, hasBonus))
                .findFirst()
                .orElse(FAIL);
    }

    private static Result findResult(Result result, int matchCount, boolean hasBonus) {
        if (matchCount != 5) {
            return result;
        }
        if (hasBonus) {
            return Result.BONUS;
        }
        return Result.FIVE;
    }

    @Override
    public String toString() {
        return message;
    }
}
