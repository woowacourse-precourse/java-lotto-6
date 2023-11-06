package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiPredicate;

public enum Rank {
    SIX((similarity, hasBonus) -> similarity.equals(6)),
    FIVE_BONUS((similarity, hasBonus) -> similarity.equals(5) && hasBonus),
    FIVE((similarity, hasBonus) -> similarity.equals(5) && !hasBonus),
    FOUR((similarity, hasBonus) -> similarity.equals(4)),
    THREE((similarity, hasBonus) -> similarity.equals(3));
    
    private final BiPredicate<Integer, Boolean> condition;

    Rank( BiPredicate<Integer, Boolean> condition) {
        this.condition = condition;
    }

    public static Optional<Rank> findRank(Integer similarity,Boolean hasBonus){
        return Arrays.stream(values()).filter(rank -> rank.hasRank(similarity,hasBonus)).findFirst();
    }

    private boolean hasRank(Integer similarity,Boolean hasBonus){
        return condition.test(similarity,hasBonus);
    }
}
