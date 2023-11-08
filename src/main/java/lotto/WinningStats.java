package lotto;

public class WinningStats {
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int fiveAndBonusMatchCount;
    private int sixMatchCount;
    private int totalTickets;

    public WinningStats(int threeMatchCount, int fourMatchCount, int fiveMatchCount, int fiveAndBonusMatchCount, int sixMatchCount) {
        this.threeMatchCount = threeMatchCount;
        this.fourMatchCount = fourMatchCount;
        this.fiveMatchCount = fiveMatchCount;
        this.fiveAndBonusMatchCount = fiveAndBonusMatchCount;
        this.sixMatchCount = sixMatchCount;
    }



    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getFiveAndBonusMatchCount() {
        return fiveAndBonusMatchCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

    public int getTotalTickets() {
        return totalTickets;
    }
}
