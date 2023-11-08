package lotto.domain;

/**
 * 수익률을 계산하는 메소드를 포함한다.
 */
public class RateOfReturnCalculator {

    /**
     * 수익률을 계산한다.
     * 계산식은 (profit / cost * 100)이다.
     * @param profit 당첨금의 총액.
     * @param cost 로또 구입 금액.
     * @return 수익률을 백분율로 계산해서 반환.
     */
    public static double calculate(int profit, int cost) {
        return (double)profit / cost * 100;
    }
}
