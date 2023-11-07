package lotto.domain;

public enum Prize {
    FIRST_CLASS(6, 2000000000, false),
    SECOND_CLASS(5, 30000000, true),
    THIRD_CLASS(5, 1500000, false),
    FOURTH_CLASS(4, 50000, false),
    FIFTH_CLASS(3, 5000, false);

    private final int match;
    private final int rewards;
    private final boolean needBonus;

    Prize(int match, int rewards, boolean needBonus) {
        this.match = match;
        this.rewards = rewards;
        this.needBonus = needBonus;
    }

    public int match() {return match;}
    public int rewards() {return rewards;}
    public boolean isItNeedBonus() {return needBonus;}

    public int totalRewards(int counts) {
        return rewards * counts;
    }
}
