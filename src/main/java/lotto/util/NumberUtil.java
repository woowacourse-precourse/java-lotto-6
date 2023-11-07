package lotto.util;

public class NumberUtil {
    public static Double calculateReturnRatio(Double initialValue, Double finalValue) {
        if (initialValue == 0) {
            throw new IllegalArgumentException("initialValue는 0이 될 수 없습니다.");
        }

        return finalValue / initialValue;
    }
}
