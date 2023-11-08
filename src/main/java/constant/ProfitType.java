package constant;

public enum ProfitType {
    one(3,"3개 일치", 5000),
    two(4,"4개 일치", 50000),
    tree(5,"5개 일치", 1500000),
    four(6,"6개 일치", 2000000000),
    five(7,"5개 일치, 보너스 볼 일치", 30000000);

    private int count;
    private String match;
    private int profit;
    ProfitType(int count, String match, int profit) {
        this.count = count;
        this.match = match;
        this.profit = profit;
    }

    public int getCount() {
        return count;
    }

    public String getMatch() {
        return match;
    }
    public int getProfit() {
        return profit;
    }

    public static ProfitType[] getProfitTypes() {
        return ProfitType.values();
    }
}
