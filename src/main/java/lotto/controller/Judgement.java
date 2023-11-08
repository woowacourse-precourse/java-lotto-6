package lotto.controller;

import lotto.constant.Prize;
import lotto.domain.Jackpot;
import lotto.domain.Lotto;

import java.util.*;

public class Judgement {
    private Calculator calculator;

    private List<Lotto> lottos;
    private Jackpot jackpot;

    public boolean isMatchedBonus = false;
    private int revenue = 0;

    public Judgement(List<Lotto> lottos, Jackpot jackpot, Calculator calculator) {
        this.lottos = lottos;
        this.jackpot = jackpot;
        this.calculator = calculator;
    }

    public int confirmJackpot() {
        for (Lotto lotto : lottos) {
            countMatchingValue(lotto);
        }
        return revenue;
    }

    private void countMatchingValue(Lotto oneLotto) {
        List<Integer> lotto = oneLotto.returnFarsighted();
        List<Integer> winning = jackpot.returnFarsighted();

        processBonus(lotto);

        long overlapCount = lotto.stream()
                .filter(winning::contains)
                .count();

        revenue += calculator.calcuratePrize(Long.valueOf(overlapCount).intValue());
        calculator.updateAccordance(Long.valueOf(overlapCount).intValue());
    }

    public void processBonus(List<Integer> lotto) {
        if (lotto.contains(jackpot.returnBonusValue())) {
            isMatchedBonus = true;
            return;
        }
        isMatchedBonus = false;
    }

    public int checkBonus() {
        if (isMatchedBonus) {
            return Prize.BONUS.findMatchingValue();
        }
        return Prize.FIVE.findMatchingValue();
    }

}
