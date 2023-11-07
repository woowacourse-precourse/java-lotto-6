package lotto.domain.result;

import java.math.BigDecimal;

public class WinningMoney {

    private BigDecimal money;

    public static WinningMoney of(Statistics statistics) {
        return new WinningMoney(statistics);
    }

    private WinningMoney(Statistics statistics) {
        this.money = BigDecimal.ZERO;

        for (GradeCount gradeCount : statistics.getGradeCounts()) {
            BigDecimal winningMoney = BigDecimal.valueOf(gradeCount.getGrade().getWinningMoney());
            BigDecimal count = BigDecimal.valueOf(gradeCount.getCount());

            this.money = this.money.add(winningMoney.multiply(count));
        }
    }

    public BigDecimal getMoney() {
        return money;
    }
}
