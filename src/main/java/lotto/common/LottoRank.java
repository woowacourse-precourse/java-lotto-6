package lotto.common;

public enum LottoRank {
    ONE(1, 2000000000, Announcement.RANK_ONE.getScript()),
    TWO(2, 30000000, Announcement.RANK_TWO.getScript()),
    THREE(3, 1500000, Announcement.RANK_THREE.getScript()),
    FOUR(4, 50000, Announcement.RANK_FOUR.getScript()),
    FIVE(5, 5000, Announcement.RANK_FIVE.getScript()),
    NOTHING(0, 0, ""),
    ;

    private final int rank;
    private final int prizeMoney;
    private final String announcementScript;

    LottoRank(int rank, int prizeMoney, String announcementScript) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
        this.announcementScript = announcementScript;
    }

    public int getRank() {
        return this.rank;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public static LottoRank getLottoRank(int rank) {
        LottoRank lottoRank = LottoRank.NOTHING;
        if (rank == LottoRank.FIVE.getRank()) {
            lottoRank = LottoRank.FIVE;
        }
        if (rank == LottoRank.FOUR.getRank()) {
            lottoRank = LottoRank.FOUR;
        }
        if (rank == LottoRank.THREE.getRank()) {
            lottoRank = LottoRank.THREE;
        }
        if (rank == LottoRank.TWO.getRank()) {
            lottoRank = LottoRank.TWO;
        }
        if (rank == LottoRank.ONE.getRank()) {
            lottoRank = LottoRank.ONE;
        }
        return lottoRank;
    }

    public void printRank(Integer count) {
        System.out.println(this.announcementScript + " - " + count + "개");
    }
}
