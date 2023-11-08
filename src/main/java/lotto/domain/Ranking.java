package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(1, "6개 일치 (2,000,000,000원) - "),
    SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(3, "5개 일치 (1,500,000원) - "),
    FOURTH(4, "4개 일치 (50,000원) - "),
    FIFTH(5, "3개 일치 (5,000원) - ");

    private static final String ERROR_MESSAGE = "[ERROR] 존재하지 않는 순위 입니다.";
    private final int rank;
    private final String message;

    Ranking(int rank, String message) {
        this.rank = rank;
        this.message = message;
    }

    public int getRank() {
        return this.rank;
    }

    public static String getMatchRankMessage(int rank) {
        return Arrays.stream(Ranking.values())
                .filter(r -> r.getRank() == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE))
                .message;
    }
}
