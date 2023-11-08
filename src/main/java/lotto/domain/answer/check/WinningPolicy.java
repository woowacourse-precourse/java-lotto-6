package lotto.domain.answer.check;

import static lotto.domain.answer.check.WinningPolicyCondition.SECOND;
import static lotto.domain.answer.check.WinningPolicyCondition.THIRD;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

public final class WinningPolicy {
    public static BiFunction<Integer, Boolean, Integer> getRank = (Integer count, Boolean hasBonusNumber) -> {
        AtomicReference<Integer> rank = new AtomicReference<>(0);
        Arrays.stream(WinningPolicyCondition.values())
                .forEach(winningPolicyCondition -> {
                    if (count == winningPolicyCondition.matchCount) {
                        if (winningPolicyCondition == THIRD) {
                            if (hasBonusNumber) {
                                rank.set(SECOND.rank);
                                return;
                            }
                            rank.set(THIRD.rank);
                            return;
                        }
                        rank.set(winningPolicyCondition.rank);
                    }
                });
        return rank.get();
    };
}

