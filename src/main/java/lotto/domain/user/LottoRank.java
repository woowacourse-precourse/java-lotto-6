package lotto.domain.user;

public enum LottoRank {
    MONEY_FIRST_PLACE("FIRST", 2000000000, 0),
    MONEY_SECOND_PLACE("SECOND", 30000000, 0),
    MONEY_THIRD_PLACE("THIRD", 1500000, 0),
    MONEY_FOURTH_PLACE("FOURTH", 50000, 0),
    MONEY_FIFTH_PLACE("FIFTH", 5000, 0);
    private final String place;
    private final Integer money;
    private Integer count;

    LottoRank(String place, Integer money, Integer count) {
        this.place = place;
        this.money = money;
        this.count = count;
    }

    public String getPlace() {
        return place;
    }

    public int getMoney() {
        return money;
    }

    public Integer getCount() {
        return count;
    }

    public void increaseCount() {
        count = count + 1;
    }

    public Integer getWinMoney() {
        return money * count;
    }
}
