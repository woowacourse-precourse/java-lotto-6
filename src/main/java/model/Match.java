package model;

public enum Match {
    MATCH_THREE("3개 일치 (5,000원) - ", 3),
    MATCH_FOUR("4개 일치 (50,000원) - ", 4),
    MATCH_FIVE("5개 일치 (1,500,000원) - ", 5),
    MATCH_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 7),
    MATCH_SIX("6개 일치 (2,000,000,000원) - ", 6);

    private final String message;
    private final int rank;

    Match(String message, int rank) {
        this.message = message;
        this.rank = rank;
    }

    public String getMessage() {
        return message;
    }

    public int getRank() {
        return rank;
    }

}
