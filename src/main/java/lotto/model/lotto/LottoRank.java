package lotto.utils;

public enum LottoRank {
    RANK_NOTHING(6, 0, ""),
    RANK5(5, 5_000, "3개 일치 (5,000원) - "),
    RANK4(4, 50_000, "4개 일치 (50,000원) - "),
    RANK3(3, 5_000, "5개 일치 (1,500,000원) - "),
    RANK2(2, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK1(1, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");


    private int rank;
    private int amount;
    private String message;

    LottoRank(int rank, int amount, String message) {
        this.rank = rank;
        this.amount = amount;
        this.message = message;
    }


}
