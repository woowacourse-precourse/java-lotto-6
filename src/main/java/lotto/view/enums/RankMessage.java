package lotto.view.enums;

public enum RankMessage {
    RANK1(1, "6개 일치 (2,000,000,000원) - "),
    RANK2(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK3(3, "5개 일치 (1,500,000원) - "),
    RANK4(4, "4개 일치 (50,000원) - "),
    RANK5(5, "3개 일치 (5,000원) - ");

    private final int rank;
    private final String string;

    RankMessage(int rank, String string) {
        this.rank = rank;
        this.string = string;
    }

    public static String getMessageByRank(int rank) {
        for (RankMessage rankMessage : RankMessage.values()) {
            if (rankMessage.rank == rank) {
                return rankMessage.string;
            }
        }
        return "";
    }
}
