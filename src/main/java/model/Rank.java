package model;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3);

    private int countOfMatch;

    Rank(int countOfMatch) {
        this.countOfMatch = countOfMatch;
    }

    public static Rank valueOf(int countOfMatch) {
        // 맞춘 숫자 개수에 따른 등수를 반환
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findAny()
                .orElse(null);
    }
}

