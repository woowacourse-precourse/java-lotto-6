package model;

public enum ResultLotto {
    EMPTY(0, 0, false),
    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    FIVE_BONUS(5, 30000000, true),
    SIX(6, 2000000000, false);
    private final Integer equalCount;
    private final Integer prize;
    private final Boolean bonus;

    ResultLotto(Integer equalCount, Integer prize, Boolean bonus) {
        this.equalCount = equalCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public Integer getEqualCount() {
        return equalCount;
    }

    public Integer getPrize() {
        return prize;
    }
    public Boolean getBonus() {
        return bonus;
    }
}
