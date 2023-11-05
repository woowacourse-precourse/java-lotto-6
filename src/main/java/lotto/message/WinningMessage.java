package lotto.message;

public enum WinningMessage {
    FIRST_RANK_MESSAGE(1, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND_RANK_MESSAGE(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_RANK_MESSAGE(3, "5개 일치 (1,500,000원) - %d개"),
    FOURTH_RANK_MESSAGE(4, "4개 일치 (50,000원) - %d개"),
    FIFTH_RANK_MESSAGE(5, "3개 일치 (5,000원) - %d개");

    private int rank;
    private String content;

    WinningMessage(int rank, String content) {
        this.rank = rank;
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }

    public int getRank() {
        return rank;
    }

    public String getContent() {
        return content;
    }
}
