package lotto.util;

import lotto.configure.OutputConfiguration;

/**
 * 유틸리티 함수를 담은 클래스.
 */
public class Utils {

    /**
     * OutputConfiguration.DECIMAL_POINT_TO_ROUND에 정의된 자리에서 반올림한다.
     * 예시)
     * 3.14 -> "3.1",
     * 5.67173 -> "5.7",
     * 3.05 -> "3.1",
     * 3.04 -> "3.0"
     * @param toRound 반올림할 값.
     * @return 반올림된 값을 표시하는 문자열.
     */
    public static String round(double toRound) {
        return String.format("%." + (OutputConfiguration.DECIMAL_POINT_TO_ROUND - 1) + "f", toRound);
    }
}
