package lotto.util;

public class NumberUtil {
    public static Float calculateReturnRatio(Float initialValue, Float finalValue) {
        if (initialValue == 0) {
            throw new IllegalArgumentException("initialValue는 0이 될 수 없습니다.");
        }

        return finalValue / initialValue * 100;
    }
}
