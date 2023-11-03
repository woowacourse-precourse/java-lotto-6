package lotto.constant;

public enum Prize {
    FIRST(6, "2,000,000,000", 2000000000),
    SECOND(5, "30,000,000", 30000000),
    THIRD(5, "1,500,000", 1500000),
    FOURTH(4, "50,000", 50000),
    FIFTH(3, "5,000", 5000),
    NONE(0, "0", 0);

    private final int match;
    private final String panel;
    private final int money;

    Prize(int match, String panel, int money) {
        this.match = match;
        this.panel = panel;
        this.money = money;
    }

    public static Prize getByMatch(int match) {
        for (Prize prize : values()) {
            if (prize.match == match) {
                return prize;
            }
        }
        return Prize.NONE;
    }

    public int getMatch() {
        return match;
    }

    public String getPanel() {
        return panel;
    }

    public int getMoney() {
        return money;
    }
}
