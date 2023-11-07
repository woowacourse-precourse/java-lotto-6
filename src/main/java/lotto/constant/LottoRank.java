package lotto.constant;

public enum LottoRank {
    MONEY_FIRST_PLACE("FIRST", 2000000000, 0),
    MONEY_SECOND_PLACE("SECOND", 30000000, 1),
    MONEY_THIRD_PLACE("THIRD", 1500000, 2),
    MONEY_FOURTH_PLACE("FOURTH", 50000, 3),
    MONEY_FIFTH_PLACE("FIFTH", 5000, 4);
    private final String place;
    private final Integer money;
    private Integer index;

    LottoRank(String place, Integer money, Integer index) {
        this.place = place;
        this.money = money;
        this.index = index;
    }

    public String getPlace() {
        return place;
    }

    public int getMoney() {
        return money;
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getWinMoney() {
        return money * index;
    }
}
