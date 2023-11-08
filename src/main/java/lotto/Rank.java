package lotto;

public enum Rank {
    RANK_1(1, 6, 2000000000, "6개 일치 (2,000,000,000원)"),
    RANK_2(2, 5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_3(3, 5, 1500000, "5개 일치 (1,500,000원)"),
    RANK_4(4, 4, 50000, "4개 일치 (50,000원)"),
    RANK_5(5, 3, 5000, "3개 일치 (5,000원)"),
    RANK_0(0, 0, 0, "");

    private final int rank;
    private final int numberCount;
    private final int prizeMoney;
    private final String printMessage;


    Rank(int rank, int numberCount, int prizeMoney, String printMessage) {
        this.rank = rank;
        this.numberCount = numberCount;
        this.prizeMoney = prizeMoney;
        this.printMessage = printMessage;
    }

    public int getRank() {
        return rank;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrintMessage() {
        return printMessage;
    }

    public static Rank checkResult(int count, boolean bonusNumber) {
        if(count == 6) return RANK_1;
        if(count == 5) {
            if(bonusNumber) return RANK_2;
            return RANK_3;
        }
        if(count == 4) return RANK_4;
        if(count == 3) return RANK_5;
        return RANK_0;
    }
}
