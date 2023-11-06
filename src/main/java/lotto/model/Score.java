package lotto.model;

import java.util.Objects;
import java.util.stream.Stream;

public enum Score {
    First(6, 2000000000),
    Second(15, 30000000),
    Third(5, 1500000),
    Fourth(4, 50000),
    Fifth(3, 5000),
    Nothing(0, 0);

    private final int point;
    private final int prize;

    Score(int point, int prize) {
        this.point = point;
        this.prize = prize;
    }

    public static Score from(int point) {
        return Stream.of(values())
                .filter(score -> Objects.equals(score.point, point))
                .findFirst()
                .orElse(Nothing);
    }

    public Score canSecond(boolean hasBonusNo) {
        if (isThird() && hasBonusNo) {
            return Second;
        }
        return this;
    }

    private boolean isThird() {
        return this == Third;
    }

    public int getPrize() {
        return this.prize;
    }
}
