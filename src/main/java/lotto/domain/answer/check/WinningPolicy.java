package lotto.domain.answer.check;

import static lotto.domain.answer.check.WinningPolicyCondition.SECOND;
import static lotto.domain.answer.check.WinningPolicyCondition.THIRD;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

public final class WinningPolicy {
    // 당첨 알고리즘 정책 적용
    public static BiFunction<Integer, Boolean, Integer> getRank = (Integer count, Boolean hasBonusNumber) -> {
        AtomicReference<Integer> rank = new AtomicReference<>(0);
        Arrays.stream(WinningPolicyCondition.values())
                .forEach(w -> {
                    if (count == w.matchCount) {
                        judgeThird(hasBonusNumber, rank, w);
                    }
                });
        return rank.get();
    };

    // 3등 판단

    static void judgeThird(Boolean hasBonusNumber, AtomicReference<Integer> rank, WinningPolicyCondition w) {
        if (w == THIRD) {
            judgeSecond(hasBonusNumber, rank);
            return;
        }
        rank.set(w.rank);
    }

    // 2등 판단

    static void judgeSecond(Boolean hasBonusNumber, AtomicReference<Integer> rank) {
        if (hasBonusNumber) {
            rank.set(SECOND.rank);
            return;
        }
        rank.set(THIRD.rank);
    }
}

