package lotto.domain.player.playermoney;

import static lotto.domain.player.playermoney.UsedMoney.makeZeroUsedMoney;

import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.domain.player.Profit;

public class PlayerWallet {
    private HoldingMoney holdingMoney;
    private UsedMoney usedMoney;

    public PlayerWallet(int initialHoldingMoney) {
        this.holdingMoney = new HoldingMoney(initialHoldingMoney);
        this.usedMoney = makeZeroUsedMoney();
    }

    public void consumeMoneyToLottoTicket(int consumeMoney) {
        usedMoney = usedMoney.updateUsedMoney(consumeMoney);
        holdingMoney = holdingMoney.consumeHoldingMoney(consumeMoney);
    }

    public int getHoldingMoney() {
        return holdingMoney.getHoldingMoney();
    }

    public int getUsedMoney() {
        return usedMoney.getUsedMoney();
    }

    public Profit calculateProfit(LottoResultsRepository lottoResultsRepository) {
        return usedMoney.calculateProfit(lottoResultsRepository);
    }
}
