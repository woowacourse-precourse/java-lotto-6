package lotto.domain;

public enum WinLotto {
    FIRST(6, 2_000_000_000, false,
            "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5, 30_000_000, true,
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개)"),
    THIRD(5, 1_500_000, false,
            "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, 50_000, false,
            "4개 일치 (50,000원) - %d개"),
    FIFTH(3, 5_000, false,
            "3개 일치 (5,000원) - %d개"),
    NONE(0, 0, false,
            "");

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;
    private final String message;
    WinLotto(int matchCount, int prize, boolean matchBonus,String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage(int count) {
        return String.format(message, count);
    }
    public static WinLotto findWin(int matchCount, boolean matchBonus) {
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


}
