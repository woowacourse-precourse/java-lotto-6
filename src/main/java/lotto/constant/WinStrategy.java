package lotto.constant;

public enum WinStrategy {
    MATCHES_THREE("3개 일치 (5,000)원", 3, 0),
    MATCHES_FOUR("4개 일치 (50,000)원", 4, 0),
    MATCHES_FIVE("5개 일치 (1,500,000원)", 5, 0),
    MATCHES_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, 1),
    MATCHES_SIX("6개 일치 (2,000,000,000원)", 6, 0);

    private final String winType;
    private final int matchCount;
    private final int bonus;

    WinStrategy(String winType, int matchCount, int bonus) {
        this.winType = winType;
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public String getWinType() {
        return this.winType;
    }

    public static String getWinType(int matchCount, int bonusCount) throws IllegalArgumentException {
        for (WinStrategy info : WinStrategy.values()) {
            if (info.getMatchCount() == matchCount && info.getBonusCount() == bonusCount) {
                return info.getWinType();
            }
        }
        throw new IllegalArgumentException();
    }

    private int getMatchCount() {
        return this.matchCount;
    }

    private int getBonusCount() {
        return this.bonus;
    }
}