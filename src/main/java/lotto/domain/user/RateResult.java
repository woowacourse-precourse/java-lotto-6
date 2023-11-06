package lotto.domain.user;

import lotto.utill.Utii;

public class RateResult {
    public Double calculateRate(Integer useMoney, Integer totalWinMoney) {
        double rate = ((double) totalWinMoney / useMoney) * 100;

        if (Utii.isSameInt(useMoney, 0)) {
            return 0.0;
        }

        return Math.round(rate * 10) / 10.0;
    }

    public StringBuilder showRate(Integer useMoney, Integer totalWinMoney) {
        StringBuilder result = new StringBuilder();
        double rate = calculateRate(useMoney, totalWinMoney);

        // TODO: 11/6/23 상수 정리 
        result.append("총 수익률은 " + rate + "%입니다.");

        return result;
    }
}
