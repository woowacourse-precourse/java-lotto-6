package lotto.domain.result;

import java.math.BigDecimal;
import lotto.domain.grade.GradeCount;

public class WinningMoney {

    private BigDecimal money;

    public static WinningMoney of() {
        return new WinningMoney();
    }

    private WinningMoney() {
        this.money = BigDecimal.ZERO;
    }

    public void apply(Statistics statistics) {
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
