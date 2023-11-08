package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public enum Prize {
    NO_PRIZE(0, 0, (matchCount, isBonusMatched) -> matchCount < 3),
    FIFTH(5000, 3, (matchCount, isBonusMatched) -> matchCount == 3),
    FOURTH(50000, 4, (matchCount, isBonusMatched) -> matchCount == 4),
    THIRD(1500000, 5, (matchCount, isBonusMatched) -> matchCount == 5 && !isBonusMatched),
    SECOND(30000000, 5, (matchCount, isBonusMatched) -> matchCount == 5 && isBonusMatched),
    FIRST(2000000000,  6, (matchCount, isBonusMatched) -> matchCount == 6);

    private static final List<Prize> PRIZES = Arrays.asList(values());

    private final int prizeMoney;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> matchCriteria;

    Prize(int prizeMoney, int matchCount, BiPredicate<Integer, Boolean> matchCriteria) {
        validate(prizeMoney, matchCount);
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.matchCriteria = matchCriteria;
    }

    public void validate(int prizeMoney, int matchCount) {
        if (prizeMoney < 0 || matchCount < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 상금과 매칭된 로또 번호 수는 음수일 수 없습니다.");
        }
    }

    public static Prize getPrize(final int matchCount, final boolean isBonusMatched) {
        return PRIZES.stream()
                .filter(prize -> prize.matchCriteria.test(matchCount, isBonusMatched))
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
