package lotto.domain;

public class Calculator {
    private static final Integer LOTTO_PRICE = 1000;
    public static Integer getNumberOfLotto(Integer amount) {
        return (amount / LOTTO_PRICE);
    }

    public static Double getEarningRate(Integer spend, Integer earn) {
        return ((double) earn / spend);
    }
}
