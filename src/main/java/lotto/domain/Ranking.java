package lotto.domain;

public enum Ranking {
    FIRST("6개 일치", 6, false, "2,000,000,000"),
    SECOND("5개 일치, 보너스 볼 일치", 5, true, "30,000,000"),
    THIRD("5개 일치", 5, false, "1,500,000"),
    FOURTH("4개 일치", 4, false, "50,000"),
    FIFTH("3개 일치", 3, false, "5,000"),
    NONE("등수 밖", 0, false, "0");

    private final String description;
    private final int matchNumber;
    private final boolean matchBonus;
    private final String prize;

    private Ranking(String description, int matchNumber, boolean matchBonus, String prize) {
        this.description = description;
        this.matchNumber = matchNumber;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public String getPrize() {
        return prize;
    }
}
