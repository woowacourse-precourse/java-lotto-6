package lotto.util;

public class NumberUtil {
    public static Double calculateReturnRatio(Double initialValue, Double finalValue) {
        if (initialValue == 0) {
            throw new IllegalArgumentException("initialValue는 0이 될 수 없습니다.");
        }

        return finalValue / initialValue;
    }

    public static Double roundToTwoDecimalPlaces(Double number) {
        // 소수점 둘째 자리에서 반올림
        return Math.round(number * 10.0) / 10.0;
    }
}
