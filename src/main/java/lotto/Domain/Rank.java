package lotto.Domain;

import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, 2000000000, false, (hitCount, isHitBonus) -> hitCount == 6),
    SECOND(5, 30000000, true, (hitCount, isHitBonus) -> hitCount == 5 && isHitBonus),
    THIRD(5, 1500000, false, (hitCount, isHitBonus) -> hitCount == 5 && !isHitBonus),
    FOURTH(4, 50000, false, (hitCount, isHitBonus) -> hitCount == 4),
    FIFTH(3, 5000, false, (hitCount, isHitBonus) -> hitCount == 3),
    NOTHING(0, 0, false, (hitCount, isHitBonus) -> hitCount <= 2);

    private final int hitCount;
    private final int prizeMoney;
    private final boolean isHitBonus;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    Rank(int hitCount, int prizeMoney, boolean isHitBonus, BiFunction<Integer, Boolean, Boolean> expression) {
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
        this.expression = expression;
        if (hitCount == 5) {
            this.isHitBonus = isHitBonus;
            return;
        }
        this.isHitBonus = false;
    }

    public boolean hit(int hitCount, boolean isHitBonus) {
       return this.expression.apply(hitCount, isHitBonus);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append(String.format("%d개 일치",hitCount));
        if(isHitBonus) {
            message.append(", 보너스 볼 일치");
        }
        message.append(String.format(" (%,d원)",prizeMoney));
        return message.toString();
    }
}
