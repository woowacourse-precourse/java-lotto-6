package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, false, "%d개 일치 (%,d원) - %d개"),
    SECOND(5, 30_000_000, true, "%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    THIRD(5, 1_500_000, false, "%d개 일치 (%,d원) - %d개"),
    FOURTH(4, 50_000, false, "%d개 일치 (%,d원) - %d개"),
    FIFTH(3, 5_000, false, "%d개 일치 (%,d원) - %d개"),
    MISS(0, 0, false, "");

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean matchBonus;
    private final String messageFormat;

    Rank(int countOfMatch, int winningMoney, boolean matchBonus, String messageFormat) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
        this.messageFormat = messageFormat;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessageFormat() {
        return messageFormat;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.countOfMatch == countOfMatch && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return MISS;
    }
}
