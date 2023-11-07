package util;

public enum LottoResultMessage {
    FIRST_RANK(1,"6개 일치 (2000,000,000원) - "),
    SECOND_RANK(2,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_RANK(3, "5개 일치 (1,500,000원) - "),
    FORTH_RANK(4, "4개 일치 (50,000원) - "),
    FIFTH_RANK(5, "3개 일치 (5,000원) - ");

    private final int rank;
    private final String messageOFRank;

    LottoResultMessage(int rank, String messageOFRank) {
        this.rank = rank;
        this. messageOFRank = messageOFRank;
    }

    public int getRank() {
        return rank;
    }

    public String getMessageOFRank() {
        return messageOFRank;
    }
}
