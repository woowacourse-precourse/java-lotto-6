package lotto.domain.player.playermoney;

import static lotto.domain.player.playermoney.UsedMoney.makeZeroUsedMoney;

import lotto.domain.lottoresult.LottoPrizeMoney;
import lotto.domain.player.LottoTicket;
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

    public Profit calculateProfit(LottoPrizeMoney lottoPrizeMoney) {
        return usedMoney.calculateProfit(lottoPrizeMoney);
    }

    public Profit calculateProfit(LottoResultsRepository lottoResultsRepository) {
        return usedMoney.calculateProfit(lottoResultsRepository);
    }
}
