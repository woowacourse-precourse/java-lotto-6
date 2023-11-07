package lotto.domain.lottoresult;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoResultStatus {

    FAIL(0, 0, (matchCount, withBonusNumber) -> matchCount < 3),
    THREE_MATCH(3, 5_000, (matchCount, withBonusNumber) -> matchCount == 3),
    FOUR_MATCH(4, 50_000, (matchCount, withBonusNumber) -> matchCount == 4),
    FIVE_MATCH(5, 1_500_000, (matchCount, withBonusNumber) -> matchCount == 5 && !withBonusNumber),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000, (matchCount, withBonusNumber) -> matchCount == 5 && withBonusNumber),
    ALL_MATCH(6, 2_000_000_000, (matchCount, withBonusNumber) -> matchCount == 6);

    private final long matchCount;
    private final int prize;
    private final BiPredicate<Long, Boolean> checker;

    LottoResultStatus(long matchCount, int prize, BiPredicate<Long, Boolean> checker) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.checker = checker;
    }

    public static LottoResultStatus checkResult(long matchCount, boolean withBonusNum) {
        return Arrays.stream(LottoResultStatus.values())
                .filter(status -> status.checker.test(matchCount, withBonusNum))
                .findAny()
                .orElse(FAIL);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
