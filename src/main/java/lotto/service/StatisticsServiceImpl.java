package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.List;

import static lotto.utils.NumberConstant.PRICE_UNIT;

public class StatisticsServiceImpl implements StatisticsService {
    private static StatisticsService instance;
    private final List<Lotto> myLottos;
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;
    private Result result = new Result();

    private StatisticsServiceImpl(List<Lotto> myLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        this.myLottos = myLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    public static StatisticsService getInstance(List<Lotto> myLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        if (instance == null) {
            instance = new StatisticsServiceImpl(myLottos, winningNumbers, bonusNumber);
        }
        return instance;
    }

    @Override
    public Result calculateResult() {
        for (Lotto myLotto : myLottos) {
            checkRank(myLotto);
        }
        return result;
    }

    @Override
    public double calculateRevenueRate(List<Lotto> lottos, Result result) {
        double revenue = result.getRevenue();
        double price = lottos.size() * PRICE_UNIT.getValue();
        double revenueRate = Math.round((revenue / price * 100)*10)/10.0;
        return revenueRate;
    }

    private void checkRank(Lotto myLotto) {
        int count = 0;
        boolean bonus = false;
        for (int number : myLotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number))
                count++;
        }
        if (myLotto.getNumbers().contains(bonusNumber))
            bonus = true;
        result.plusRank(count, bonus);
    }
}
