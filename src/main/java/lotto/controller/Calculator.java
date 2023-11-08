package lotto.controller;

import lotto.constant.LottoAnnouncer;
import lotto.constant.Prize;
import lotto.view.Output;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;

public class Calculator {

    private LinkedHashMap<Integer, Integer> accordance;
    private DecimalFormat decimalFormat = new DecimalFormat("###,##0.##");

    private Judgement judgement;
    private Output output = Output.getOutput();

    public Calculator(Judgement judgement) {
        this.judgement = judgement;

        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        setAccordance();
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

    public void updateAccordance(int overlapCount) {
        try {
            int getValue = accordance.get(overlapCount);
            subdivideKey(overlapCount, getValue);
        } catch (Exception e) {
        }
    }

    private Integer subdivideKey(int overlapCount, int getValue) {
        if (overlapCount == 5
                && !judgement.isMatchedBonus) {
            return accordance.put(5, ++getValue);
        } else if (overlapCount == 5
                && judgement.isMatchedBonus) {
            return accordance.put(6, ++getValue);
        } else if (overlapCount == 6) {
            return accordance.put(7, ++getValue);
        }
        return accordance.put(overlapCount, ++getValue);
    }

    public void printRate() {
        output.printMessage(LottoAnnouncer.PRIZE_STATISTICS.getMessage());
        output.printMessage(LottoAnnouncer.SEPARATOR.getMessage());
        output.printMessage(LottoAnnouncer.ACCORDANCE_THREE.getIntFormat(accordance.get(3)));
        output.printMessage(LottoAnnouncer.ACCORDANCE_FOUR.getIntFormat(accordance.get(4)));
        output.printMessage(LottoAnnouncer.ACCORDANCE_FIVE.getIntFormat(accordance.get(5)));
        output.printMessage(LottoAnnouncer.ACCORDANCE_BONUS.getIntFormat(accordance.get(6)));
        output.printMessage(LottoAnnouncer.ACCORDANCE_SIX.getIntFormat(accordance.get(7)));
    }

    public int calcuratePrize(int prize) {
        if (prize == 0 || prize == 1 || prize == 2) {
            return 0;
        }

        if (prize == 3) {
            return Prize.THREE.findMatchingValue();
        } else if (prize == 4) {
            return Prize.FOUR.findMatchingValue();
        } else if (prize == 5) {
            return judgement.checkBonus();
        }
        return Prize.SIX.findMatchingValue();
    }

    public void printRevenue(int payment, int revenue) {
        String revenueValue = formatRevenue(payment, revenue);

        output.printMessage(LottoAnnouncer.RATE_OF_RETURN.getFormat(revenueValue));
    }

    private String formatRevenue(int payment, int revenue) {
        float rateOfReturn = calculateIncome(payment, revenue);
        return decimalFormat.format(rateOfReturn);
    }

    private float calculateIncome(int payment, int revenue) {
        float income = payment - revenue;
        income = payment - income;
        income /= payment;
        return income * 100;
    }
}