package lotto.model;

import java.util.Objects;
import java.util.stream.Stream;

public enum Score {
    First(6),
    Second(15),
    Third(5),
    Fourth(4),
    Fifth(3),
    Nothing(0);

    private final int point;

    Score(int point) {
        this.point = point;
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
}
