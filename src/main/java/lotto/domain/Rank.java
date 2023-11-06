package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiPredicate;

public enum Rank {
    SIX(6),
    FIVE_BONUS(5),
    FIVE(5),
    FOUR(4),
    THREE(3);

    private final int count;

    Rank(int count) {
        this.count = count;
    }

    public static Optional<Rank> findRank(Integer similarity, Boolean hasBonus) {
        return Arrays.stream(RankCondition.values())
                .filter(rank -> rank.isMeetCondition(similarity, hasBonus))
                .map(rankCondition -> rankCondition.rank)
                .findFirst();
    }


    private enum RankCondition {
        SIX_CONDITION((similarity, hasBonus) -> similarity.equals(SIX.count), SIX),
        FIVE_BONUS_CONDITION((similarity, hasBonus) -> similarity.equals(FIVE_BONUS.count) && hasBonus, FIVE_BONUS),
        FIVE_CONDITION((similarity, hasBonus) -> similarity.equals(FIVE.count) && !hasBonus, FIVE),
        FOUR_CONDITION((similarity, hasBonus) -> similarity.equals(FOUR.count), FOUR),
        THREE_CONDITION((similarity, hasBonus) -> similarity.equals(THREE.count), THREE);
        private final BiPredicate<Integer, Boolean> condition;
        private final Rank rank;

        RankCondition(BiPredicate<Integer, Boolean> condition, Rank rank) {
            this.condition = condition;
            this.rank = rank;
        }

        private boolean isMeetCondition(Integer similarity, Boolean hasBonus) {
            return condition.test(similarity, hasBonus);
        }
    }
}
