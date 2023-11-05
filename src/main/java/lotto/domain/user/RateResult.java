package lotto.domain.user;

import lotto.utill.Utii;

/**
 * 사용자의 수익률 클래스
 */
public class RateResult {
    // 해당 로또 당첨금과 당청액수을 곱한 것들의 합과 구입한 가격을 나눈다.
    //   총 수익률은 62.5%입니다.
    // 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
    public Double calculateRate(Integer useMoney, Integer totalWinMoney) {
        double rate = ((double) totalWinMoney / useMoney) * 100; // 수익률을 계산합니다.

        if (Utii.isSameInt(useMoney, 0)) {
            return 0.0; // 만약 사용한 돈이 0이면 수익률은 0%입니다.
        }

        return Math.round(rate * 10) / 10.0; // 소수점 둘째 자리에서 반올림합니다.
    }

    public StringBuilder showRate(Integer useMoney, Integer totalWinMoney) {
        StringBuilder result = new StringBuilder();
        double rate = calculateRate(useMoney, totalWinMoney);

        result.append("총 수익률은 " + rate + "%입니다.");

        return result;
    }
}
