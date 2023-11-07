package lotto.constant;

public enum LottoRank {
    MONEY_FIRST_PLACE(2000000000, 0),
    MONEY_SECOND_PLACE(30000000, 1),
    MONEY_THIRD_PLACE(1500000, 2),
    MONEY_FOURTH_PLACE(50000, 3),
    MONEY_FIFTH_PLACE(5000, 4);
    private final Integer money;
    private Integer index;

    LottoRank(Integer money, Integer index) {
        this.money = money;
        this.index = index;
    }

    public int getMoney() {
        return money;
    }

    public Integer getIndex() {
        return index;
    }

}
