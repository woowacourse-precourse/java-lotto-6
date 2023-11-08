package constant;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);
    private final int correctCount;
    private final boolean isBonus;
    private final int prize;
    Rank(int correctCount, boolean isBonus, int prize){
        this.correctCount = correctCount;
        this.isBonus = isBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public static Rank getRank(int correctCount, boolean correctBonusNumber){
        for(Rank rank : values()){
            if(rank.correctCount == correctCount
            && rank.isBonus == correctBonusNumber)
                return rank;
        }
        return NONE;
    }

}
