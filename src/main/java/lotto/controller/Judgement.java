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

    private List<Lotto> lottos;
    private Jackpot jackpot;

    private DecimalFormat decimalFormat = new DecimalFormat("###,##0.##");

    private boolean isMatchedBonus = false;
    private int revenue = 0;
    private LinkedHashMap<Integer, Integer> accordance;

    public Judgement(List<Lotto> lottos, Jackpot jackpot) {
        this.lottos = lottos;
        this.jackpot = jackpot;

        setAccordance();

        output.printMessage(LottoAnnouncer.PRIZE_STATISTICS.getMessage());
        output.printMessage(LottoAnnouncer.SEPARATOR.getMessage());
    }

    private void setAccordance() {
        accordance = new LinkedHashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
            put(7, 0);
        }};
    }

    private void updateAccordance(int overlapCount) {
        try {
            int getValue = accordance.get(overlapCount);
            subdivideKey(overlapCount, getValue);
        } catch (Exception e) {
            return;
        }
    }

    private Integer subdivideKey(int overlapCount, int getValue) {
        if (overlapCount == 5
                && !isMatchedBonus) {
            return accordance.put(5, ++getValue);
        } else if (overlapCount == 5
                && isMatchedBonus) {
            return accordance.put(6, ++getValue);
        } else if (overlapCount == 6) {
            return accordance.put(7, ++getValue);
        }
        return accordance.put(overlapCount, ++getValue);
    }

    private void processBonus(List<Integer> lotto) {
        if (lotto.contains(jackpot.returnBonusValue())) {
            isMatchedBonus = true;
            return;
        }
        isMatchedBonus = false;
    }

    public void confirmJackpot() {
        for (Lotto lotto : lottos) {
            countMatchingValue(lotto);
        }
    }

    private void countMatchingValue(Lotto oneLotto) {
        List<Integer> lotto = oneLotto.returnFarsighted();
        List<Integer> winning = jackpot.returnFarsighted();

        processBonus(lotto);

        long overlapCount = lotto.stream()
                .filter(winning::contains)
                .count();

        revenue += calcuratePrize(Long.valueOf(overlapCount).intValue());
        updateAccordance(Long.valueOf(overlapCount).intValue());
    }

    private int calcuratePrize(int prize) {
        if (prize == 0 || prize == 1 || prize == 2) {
            return 0;
        }

        if (prize == 3) {
            return Prize.THREE.findMatchingValue();
        } else if (prize == 4) {
            return Prize.FOUR.findMatchingValue();
        } else if (prize == 5) {
            return checkBonus();
        }
        return Prize.SIX.findMatchingValue();
    }

    private int checkBonus() {
        if (isMatchedBonus) {
            return Prize.BONUS.findMatchingValue();
        }
        return Prize.FIVE.findMatchingValue();
    }

    public void printRate() {
        output.printMessage(LottoAnnouncer.ACCORDANCE_THREE.getIntFormat(accordance.get(3)));
        output.printMessage(LottoAnnouncer.ACCORDANCE_FOUR.getIntFormat(accordance.get(4)));
        output.printMessage(LottoAnnouncer.ACCORDANCE_FIVE.getIntFormat(accordance.get(5)));
        output.printMessage(LottoAnnouncer.ACCORDANCE_BONUS.getIntFormat(accordance.get(6)));
        output.printMessage(LottoAnnouncer.ACCORDANCE_SIX.getIntFormat(accordance.get(7)));
    }

    public void printRevenue(int payment) {
        float rateOfReturn = calcurateRevenue(payment);
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        String revenueValue = decimalFormat.format(rateOfReturn);

        output.printMessage(LottoAnnouncer.RATE_OF_RETURN.getFormat(revenueValue));
    }

    private float calcurateRevenue(int payment) {
        float value = revenue - payment;
        value /= (double)payment;
        value *= 100;
        return 100 + value;
    }

}
