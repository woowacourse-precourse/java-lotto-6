package lotto.domain.player.playermoney;

import lotto.domain.lottoresult.LottoPrizeMoney;
import lotto.domain.player.LottoTicket;
import lotto.domain.player.Profit;

public class UsedMoney {
    private final static int HUNDRED_FOR_CALCULATE_PERCENTAGE = 100;
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

    Profit calculateProfit(LottoResultsRepository lottoResultsRepository) {
        double totalLottoPrizeMoney = lottoResultsRepository.getTotalLottoPrizeMoney();
        return new Profit(((totalLottoPrizeMoney / usedMoney) * HUNDRED_FOR_CALCULATE_PERCENTAGE));
    }
}
