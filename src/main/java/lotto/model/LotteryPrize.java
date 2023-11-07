package lotto.model;

public enum LotteryPrize {
    FIRST("6개 일치", 2000000000, 0),
    SECOND("5개 일치, 보너스 볼 일치", 30000000, 0),
    THIRD("5개 일치", 1500000, 0),
    FOURTH("4개 일치", 50000, 0),
    FIFTH("3개 일치", 5000, 0);

    private String matchingResultText;
    private int prizeAmount;
    private int count;

    LotteryPrize(String matchingResultText, int prizeAmount, int count) {
        this.matchingResultText = matchingResultText;
        this.prizeAmount = prizeAmount;
        this.count = count;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getProfit() {
        return prizeAmount * count;
    }

    public String getMatchingResult() {
        return matchingResultText;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return String.format("%s (%,d원) - %d개", matchingResultText, prizeAmount, count);
    }

}
