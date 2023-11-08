package domain;

import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, 2000000000, false, (count, bonus) -> count == 6),
    SECOND(5, 30000000, true, (count, bonus) -> count == 5 && bonus),
    THIRD(5, 1500000, false, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, 50000, false, (count, bonus) -> count == 4),
    FIFTH(3, 5000, false, (count, bonus) -> count == 3),
    MISS(0, 0, false, (count, bonus) -> count <= 2);

    private final int matchCount;
    private final int prize;
    private final boolean hasBonus;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    Rank(int matchCount, int prize, boolean hasBonus, BiFunction<Integer, Boolean, Boolean> expression) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
        this.expression = expression;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }

    public boolean win(int count, boolean bonus) {
        return expression.apply(count, bonus);
    }

    public long multiple(Integer count) {
        return (long) prize * count;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d개 일치", matchCount));
        if (hasBonus) {
            output.append(", 보너스 볼 일치");
        }
        output.append(String.format(" (%,d원)", prize));
        return output.toString();
    }
}
