package lotto.domain;

public enum LottoScore {
    FIRST_PLACE("6개 일치", " (2,000,000,000원)", 2000000000, 6, false),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", " (30,000,000원)", 30000000, 5, true),
    THIRD_PLACE("5개 일치", " (1,500,000원)", 1500000, 5, false),
    FOURTH_PLACE("4개 일치", " (50,000원)", 50000, 4, false),
    FIFTH_PLACE("3개 일치", " (5,000원)", 5000, 3, false),
    NOTHING("0개 일치", " (0원)", 0, 0, false);

    private final String name;
    private final String value;
    private final int money;
    private final int count;
    private final boolean isContainsBonus;

    LottoScore(String name, String value, int money, int count, boolean isContainsBonus) {
        this.name = name;
        this.value = value;
        this.money = money;
        this.count = count;
        this.isContainsBonus = isContainsBonus;
    }
    public String getName() {
        return this.name;
    }
    public String getValue() {
        return this.value;
    }

    public int getMoney() {
        return this.money;
    }

    public boolean compare(int count, boolean isContainsBonus) {
        if (this.count == count && this.isContainsBonus == isContainsBonus) {
            return true;
        }
        return false;
    }
}
