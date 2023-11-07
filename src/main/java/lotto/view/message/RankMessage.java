package lotto.view.message;

import java.util.Arrays;

public enum RankMessage {
    MESSAGE_FIRST("6개 일치 (2,000,000,000원) - %d개", 1),
    MESSAGE_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 2),
    MESSAGE_THIRD("5개 일치 (1,500,000원) - %d개", 3),
    MESSAGE_FOURTH("4개 일치 (50,000원) - %d개", 4),
    MESSAGE_FIFTH("3개 일치 (5,000원) - %d개", 5);

    private final String message;
    private final int rank;

    RankMessage(String message, int rank) {
        this.message = message;
        this.rank = rank;
    }

    public static RankMessage findByRank(int rank) {
        return Arrays.stream(values())
                .filter(v -> v.getRank() == rank)
                .findAny()
                .orElse(null);
    }

    public String getMessage() {
        return message;
    }

    public int getRank() {
        return rank;
    }
}
