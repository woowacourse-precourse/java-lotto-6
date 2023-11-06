package lotto.domain.user;

import lotto.utill.Utii;

public class RateResult {
    // TODO: 11/6/23 상수 정리
    private static final Integer ZERO_MONEY = 0;
    private static final Double ZERO_RATE = 0.0;

    public Double calculateRate(Integer useMoney, Integer totalWinMoney) {
        Double rate = getRate(useMoney, totalWinMoney);

        if (isSameZERO(useMoney)) {
            return ZERO_RATE;
        }

        return roundTwoDecimalPlaces(rate);
    }

    public StringBuilder giveRateResult(Integer useMoney, Integer totalWinMoney) {
        StringBuilder result = new StringBuilder();
        Double rate = calculateRate(useMoney, totalWinMoney);

        // TODO: 11/6/23 상수 정리
        result.append("총 수익률은 " + rate + "%입니다.");

        return result;
    }

    private double roundTwoDecimalPlaces(Double rate) {
        return Math.round(rate * 10) / 10.0;
    }

    private boolean isSameZERO(Integer useMoney) {
        return Utii.isSameInt(useMoney, ZERO_MONEY);
    }

    private double getRate(Integer useMoney, double totalWinMoney) {
        return (totalWinMoney / useMoney) * 100;
    }
}
