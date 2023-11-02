package lotto.domain.player.playermoney;

public class UsedMoney {
    private final int usedMoney;

    public UsedMoney(int usedMoney) {
        this.usedMoney = usedMoney;
    }

    public UsedMoney updateUsedMoney(int consumeMoney) {
        return new UsedMoney(usedMoney + consumeMoney);
    }

    public int getUsedMoney() {
        return usedMoney;
    }
}
