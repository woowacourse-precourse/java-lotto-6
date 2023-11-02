package lotto.domain.player.playermoney;

public class PlayerMoney {
    private HoldingMoney holdingMoney;
    private UsedMoney usedMoney;

    public PlayerMoney(int holdingMoney) {
        this.holdingMoney = new HoldingMoney(holdingMoney);
        this.usedMoney = new UsedMoney(0);
    }

    public void consumeMoneyToLottoTicket(int consumeMoney) {
        usedMoney = usedMoney.updateUsedMoney(consumeMoney);
        holdingMoney = holdingMoney.consumeHoldingMoney(consumeMoney);
    }

    public int getUsedMoney() {
        return usedMoney.getUsedMoney();
    }
}
