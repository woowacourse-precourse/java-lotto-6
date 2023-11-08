package lotto.controller;

import lotto.constant.LottoAnnouncer;
import lotto.constant.Prize;
import lotto.domain.Jackpot;
import lotto.domain.Lotto;
import lotto.view.Output;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Judgement {
    private Output output = Output.getOutput();
    private Calculator calculator;

    private List<Lotto> lottos;
    private List<Integer> winning;
    private Jackpot jackpot;
    private List<Integer> lotto;

    public boolean isMatchedBonus = false;
    private int revenue = 0;

    public Judgement(List<Lotto> lottos, Jackpot jackpot, Calculator calculator) {
        this.lottos = lottos;
        this.jackpot = jackpot;
        this.calculator = calculator;

        output.printMessage(LottoAnnouncer.PRIZE_STATISTICS.getMessage());
        output.printMessage(LottoAnnouncer.SEPARATOR.getMessage());
    }

    public int confirmJackpot() {
        for (Lotto lotto : lottos) {
            countMatchingValue(lotto);
        }
        return revenue;
    }

    private void countMatchingValue(Lotto oneLotto) {
        lotto = oneLotto.returnFarsighted();
        winning = jackpot.returnFarsighted();

        processBonus();

        long overlapCount = lotto.stream()
                .filter(winning::contains)
                .count();

        revenue += calculator.calcuratePrize(Long.valueOf(overlapCount).intValue());
        calculator.updateAccordance(Long.valueOf(overlapCount).intValue());
    }

    public void processBonus() {
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
