package lotto.data;

public enum Rewards {
    FIRST(
            6,
            false,
            2000000000,
            "6개 일치"
    ),
    SECOND(
            5,
            true,
            30000000,
            "5개 일치, 보너스 볼 일치"
    ),
    THIRD(
            5,
            false,
            1500000,
            "5개 일치"
    ),
    FOURTH(
            4,
            false,
            50000,
            "4개 일치"
    ),
    FIFTH(
            3,
            false,
            5000,
            "3개 일치"
    );

    private final int correctLottos;
    private final boolean correctBonus;
    private final int money;
    private final String notifyMessege;

    Rewards(int correctLottos, boolean correctBonus, int money, String notifyMessege) {
        this.correctLottos = correctLottos;
        this.correctBonus = correctBonus;
        this.money = money;
        this.notifyMessege = notifyMessege;

    }


    public int correctLottos() {
        return correctLottos;
    }

    public boolean correctBonus() {
        return correctBonus;
    }

    public int money() {
        return money;
    }

    public String getNotifyMessege() {
        return notifyMessege;
    }


}
