package lotto;

public enum Rank {
    FIRST("1등", "2,000,000,000원",0),
    SECOND("2등", "30,000,000원",0),
    THIRD("3등", "1,500,000원",0),
    FOURTH("4등", "50,000원",0),
    FIFTH("5등", "5,000원",0);

    private final String rank;
    private final String reward;
    private int count = 0;

    Rank(String rank, String reward,int count) {
        this.rank = rank;
        this.reward = reward;
        this.count = count;
    }

    public void increaseCount() {
        this.count++;
    }

    public String getRank() {
        return this.rank;
    }

    public String getReward() {
        return this.reward;
    }

    public Integer getCount() {
        return this.count;
    }
}
