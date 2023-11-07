package lotto;

public enum WinLotto {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;
    WinLotto(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static WinLotto of(int matchCount, boolean matchBonus) {
        if(matchCount == 6)
                 return FIRST;
        if(matchCount == 5 && matchBonus)
                 return SECOND;
        if(matchCount == 5)
                return THIRD;
        if(matchCount == 4)
                return FOURTH;
        if(matchCount == 3)
                return FIFTH;
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
