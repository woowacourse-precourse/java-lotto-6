package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiPredicate;
import lotto.domain.money.Money;

public enum Rank {
    SIX(6, Money.from(2000000000)),
    FIVE_BONUS(5, Money.from(30000000)),
    FIVE(5, Money.from(1500000)),
    FOUR(4, Money.from(50000)),
    THREE(3, Money.from(5000));

    private final int count;

    private final Money money;

    Rank(int count, Money price) {
        this.count = count;
        this.money = price;
    }

    public int getCount() {
        return count;
    }

    public Money getMoney(){
        return money;
    }

    public Integer toPriceInt(){
        return money.toInt();
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
