package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.List;

public class StatisticsServiceImpl implements StatisticsService{
    private final List<Lotto> myLottos;
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;
    private Result result = new Result();

    public StatisticsServiceImpl(List<Lotto> myLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        this.myLottos = myLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public Result calculateResult() {
        for (Lotto myLotto : myLottos) {
            checkRank(myLotto);
        }
        return result;
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
