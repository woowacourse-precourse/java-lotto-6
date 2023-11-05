package lotto.domain.player.playermoney;

import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.domain.player.Profit;

public class UsedMoney {
    private final static int T = 1000;
    private final static double U = 10.0;
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

    int getUsedMoney() {
        return usedMoney;
    }

    Profit calculateProfit(LottoResultsRepository lottoResultsRepository) {
        double totalLottoPrizeMoney = lottoResultsRepository.getTotalLottoPrizeMoney();
        return new Profit((Math.round((totalLottoPrizeMoney / usedMoney) * T) / U));
    }
}
