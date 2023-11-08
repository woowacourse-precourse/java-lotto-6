package lotto.data;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(6, 30000000),
    FIRST(7, 2000000000);

    private final int number;
    private final int money;

    Prize(int number, int money) {
        this.number = number;
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public int getMoney() {
        return money;
    }

    public static int getMoneyByNumber(int number) {
        for (Prize prize : Prize.values()) {
            if (prize.getNumber() == number) {
                return prize.getMoney();
            }
        }
        return 0;
    }
}
