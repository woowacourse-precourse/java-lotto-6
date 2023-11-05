package lotto.domain.player.playermoney;

import lotto.domain.lottoresult.LottoPrizeMoney;
import lotto.domain.player.LottoTicket;
import lotto.domain.player.Profit;

public class UsedMoney {
    private static final int LOTTO_PRICE = 1000;
    private final int usedMoney;

    private UsedMoney(int usedMoney) {
        this.usedMoney = usedMoney;
    }

    public static UsedMoney makeZeroUsedMoney() {
        return new UsedMoney(0);
    }

    UsedMoney updateUsedMoney(int consumeMoney) {
        return new UsedMoney(usedMoney + consumeMoney);
    }

    Profit calculateProfit(LottoPrizeMoney lottoPrizeMoney) {
        return lottoPrizeMoney.calculateProfit(usedMoney);
    }

    public LottoTicket issueLottoTicket() {
        return new LottoTicket(usedMoney / LOTTO_PRICE);
    }
}
