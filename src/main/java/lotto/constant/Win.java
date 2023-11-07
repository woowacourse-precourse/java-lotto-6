package lotto.constant;

public enum Win {
    THREE_SAME(3, 5000)
    , FOUR_SAME(4, 50000)
    , FIVE_SAME(5, 1500000)
    , SIX_SAME(6, 2000000000)
    , BONUS_ON_FIVE_SAME(50, 30000000);

    private final int same;
    private final int money;

    Win(int same, int money) {
        this.same = same;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
