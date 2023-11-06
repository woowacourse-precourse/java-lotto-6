package lotto.domain;

public enum Rank {
    NONE(0, 0, false, "불일치"),
    FIFTH(3, 5000, true,"3개 일치 (5,000원)"),
    FOURTH(4, 50000, true,"4개 일치 (50,000원)"),
    THIRD(5, 1500000, true,"5개 일치 (1,500,000원)"),
    SECOND(6, 30000000, true,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, false,"6개 일치 (2,000,000,000원)");

    private final int count;
    private final int profit;
    private final boolean checkBonusNumber;
    private final String message;

    Rank(int count, int profit, boolean checkBonusNumber, String message) {
        this.count = count;
        this.profit = profit;
        this.checkBonusNumber = checkBonusNumber;
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public static Rank valueOf(Integer count, boolean checkBonusNumber) {
        for(Rank rank : Rank.values()){
            if(rank.getCount() == count && rank.checkBonusNumber == checkBonusNumber){
                return rank;
            }
        }
        return NONE;
    }

    public int getProfit() {
        return profit;
    }

    public String getMessage() {
        return message;
    }
}
