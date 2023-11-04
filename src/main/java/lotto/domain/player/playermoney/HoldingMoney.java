package lotto.domain.player.playermoney;

public class HoldingMoney{
    private final int holdingMoney;

    HoldingMoney(int holdingMoney) {
        this.holdingMoney = holdingMoney;
    }

    HoldingMoney consumeHoldingMoney(int consumeMoney) {
        return new HoldingMoney(holdingMoney - consumeMoney);
    }

    int getHoldingMoney() {
        return holdingMoney;
    }
}
