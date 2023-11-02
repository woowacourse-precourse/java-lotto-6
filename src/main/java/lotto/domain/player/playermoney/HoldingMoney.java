package lotto.domain.player.playermoney;

public class HoldingMoney{
    private final int holdingMoney;

    public HoldingMoney(int holdingMoney) {
        this.holdingMoney = holdingMoney;
    }

    public HoldingMoney consumeHoldingMoney(int consumeMoney) {
        return new HoldingMoney(holdingMoney - consumeMoney);
    }

    public int getHoldingMoney() {
        return holdingMoney;
    }
}
