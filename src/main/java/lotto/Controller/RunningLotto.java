package lotto.Controller;

import lotto.LottoFactory.Lotto;
import lotto.LottoFactory.LottoContainer;
import lotto.LottoFactory.LottoController;
import lotto.Util.RateCalculator;

public class RunningLotto implements Running {
    private static LottoContainer lottoContainer;
    private static LottoController lottoController;
    private int count;
    private int bonus;
    private double rate;

    public RunningLotto(LottoConfiguration lottoConfig, int count, int bonus) {
        this.lottoContainer = lottoConfig.getLottoContainer();
        this.lottoController = lottoConfig.getLottoController();
        this.count = count;
        this.bonus = bonus;
    }

    @Override
    public void RunLotto() {
        for (Lotto lotto : lottoContainer.getLottoContainer()) {
            Boolean isBonusDuplicate = lotto.getNumbers().contains(bonus);
            lottoController.CheckDuplicateNum(lottoContainer, lotto, isBonusDuplicate);
        }
        int AllPrize = lottoController.returnAllPrize();
        int cash = count*1000;
        System.out.println("cash = " + cash);
        rate = RateCalculator.returnRate(AllPrize,cash);
        System.out.println("rate = " + rate);
    }

    @Override
    public double ReturnRate() {
        return rate;
    }

}
