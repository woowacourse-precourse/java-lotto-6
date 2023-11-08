package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Score {
    First(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    Second(15, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    Third(5, 1500000, "5개 일치 (1,500,000원)"),
    Fourth(4, 50000, "4개 일치 (50,000원)"),
    Fifth(3, 5000, "3개 일치 (5,000원)"),
    Nothing(0, 0, "");

    private static final String DASH = " - ";
    private static final String COUNT_MSG = "개";
    private static final String LINE_BREAK = "\n";
    private final int point;
    private final int prize;
    private final String msg;

    Score(int point, int prize, String msg) {
        this.point = point;
        this.prize = prize;
        this.msg = msg;
    }

    public static Score from(int point) {
        return Stream.of(values())
                .filter(score -> Objects.equals(score.point, point))
                .findFirst()
                .orElse(Nothing);
    }

    public Score convertSecondIfPossible(boolean hasBonusNo) {
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

    public static String stats(List<Score> scores) {
        return Stream.of(values())
                .filter(score -> !Objects.equals(score, Nothing))
                .map(score -> score.msg +
                        DASH +
                        Collections.frequency(scores, score) +
                        COUNT_MSG)
                .collect(Collectors.joining(LINE_BREAK));
    }
}
