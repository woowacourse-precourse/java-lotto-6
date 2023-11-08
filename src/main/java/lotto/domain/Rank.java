package lotto.domain;

public enum Rank {
    NONE(0, 0,  "불일치"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000,"4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(6, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int count;
    private final int profit;
    private final String message;

    Rank(int count, int profit, String message) {
        this.count = count;
        this.profit = profit;
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public static Rank valueOf(Integer count, boolean checkBonusNumber) {
        if(count == 6 && !checkBonusNumber){
            return FIRST;
        }
        if(count == 6 && checkBonusNumber){
            return SECOND;
        }
        for(Rank rank : Rank.values()){
            if(rank.count == count){
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
