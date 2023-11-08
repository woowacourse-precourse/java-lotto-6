package lotto.data;

public enum Prize {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
    BONUS(9, 30000000);

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
