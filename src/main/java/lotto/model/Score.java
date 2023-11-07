package lotto.model;

import java.util.Arrays;


public enum Score {
    FIRST("1등", 2_000_000_000), SECOND("2등", 30_000_000), THIRD("3등", 1_5000_000), FORTH("4등", 50_000), FIFTH("5등", 5_000);
    private String rank;
    private int point;

    Score(String rank, int point) {
        this.rank = rank;
        this.point = point;
    }

    public int getPoint(String rank) {
        return Arrays.stream(Score.values())
                .filter(score -> score.equals(rank))
                .mapToInt(score -> score.point)
                .sum();
    }
}

