package lotto.data;

public enum Rewards {
    FIRST(6, 0, 2000000000, "2,000,000,000"),
    SECOND(5, 1, 30000000, "30,000,000"),
    THIRD(5, 0, 1500000, "1,500,000"),
    FOURTH(4, 0, 50000, "50,000"),
    FIFTH(3, 0, 5000, "5,000");

    private final int correctLottos;
    private final int correctBonus;
    private final int money;
    private final String notifyMoney;

    private Rewards(int correctLottos, int correctBonus, int money, String notifyMoney) {
        this.correctLottos = correctLottos;
        this.correctBonus = correctBonus;
        this.money = money;
        this.notifyMoney = notifyMoney;
    }

    public int getCorrectLottos() {
        return correctLottos;
    }

    public int getCorrectBonus() {
        return correctBonus;
    }

    public int getMoney() {
        return money;
    }

    public String getNotifyMoney() {
        return notifyMoney;
    }


}
