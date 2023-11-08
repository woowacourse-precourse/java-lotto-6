package lotto;

public enum Prize {
    FIRST(0,6,false,"2,000,000,000"),
    SECOND(1,5,true,"30,000,000"),
    THIRD(2,5,false,"1,500,000"),
    FOURTH(3,4,false,"50,000"),
    FIFTH(4,3,false,"5,000");

    private final int index;
    private final int sameAmount;
    private final boolean IsBonus;
    private final String reward;

    Prize(int index, int sameAmount, boolean IsBonus, String reward) {
        this.index = index;
        this.sameAmount = sameAmount;
        this.IsBonus = IsBonus;
        this.reward = reward;
    }

    public static Prize valueOf(int sameAmount, boolean IsBonus) {
        if()
    }
}
