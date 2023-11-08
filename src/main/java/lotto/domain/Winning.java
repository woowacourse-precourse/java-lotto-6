package lotto.domain;

public enum Winning {
    FIRST_PLACE(6, new Money(2000000000)),
    SECOND_PLACE(5, true, new Money(30000000)),
    THIRD_PLACE(5, new Money(1500000)),
    FOURTH_PLACE(4, new Money(50000)),
    FIFTH_PLACE(3, new Money(5000));

    private int matchCount;
    private Money amount;
    private boolean isIncludeBonus;

    Winning(int matchCount, Money amount) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.isIncludeBonus = false;
    }

    Winning(int matchCount, boolean isIncludeBonus, Money amount) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.isIncludeBonus = isIncludeBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getAmount() {
        return amount;
    }

    public boolean isIncludeBonus() {
        return isIncludeBonus;
    }
}
