package lotto.model;

public enum Rank {
    FIRST(6,"6개 일치", 2000000000),
    SECOND(7,"5개 일치, 보너스 볼 일치", 30000000),
    THIRD(5,"5개 일치", 1500000),
    FOURTH(4,"4개 일치",50000),
    FIFTH(3,"3개 일치", 5000);

    private final int match;
    private final String state;
    private final int prize;

    public String getState() {
        return state;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }
    public boolean include(int match){
        if(this.match==match){
            return true;
        }
        return false;
    }

    Rank(int match, String state, int prize) {
        this.match = match;
        this.state = state;
        this.prize = prize;
    }
}
