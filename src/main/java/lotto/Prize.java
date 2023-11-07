package lotto;

enum Prize {
    FIRST("FIRST", 6, true, 2_000_000_000),
    SECOND("SECOND", 5, true, 30_000_000),
    THIRD("THIRD", 5, false, 1_500_000),
    FOURTH("FOURTH", 4, true, 50_000),
    FIFTH("FIFTH", 3, true, 5_000);
    private final String name;
    private final boolean bonus;
    private final int match;
    private final int profit;

    Prize(String name, int match, boolean bonus, int profit) {
        this.name = name;
        this.match = match;
        this.bonus = bonus;
        this.profit = profit;
    }

    public int getMatch() {
        return match;
    }

    public int getProfit() {
        return profit;
    }

    public String getName() {
        return name;
    }

    public boolean getBonus() {
        return bonus;
    }
}
