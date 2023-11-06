package lotto.util;

import lotto.configure.InputConfiguration;

import java.util.Arrays;
import java.util.List;

/**
 * 문자열 데이터를 활용할 수 있는 데이터로 변환하는 클래스.
 * 각 문자열의 의도에 따라 문자열을 알맞는 데이터로 변환한다.
 * 변환된 데이터를 검증한다.
 * 이 클래스의 모든 메소드들은 static 메소드로 선언된다.
 */
public class StringConverter {

    /**
     * 주어진 문자열을 정수 데이터 타입으로 변환한다.
     * @param toConvert 변환할 문자열. 문자열은 정수를 나타내야 한다.
     * @return toConvert가 나타내는 정수 값을 반환한다.
     */
    public static int toInt(String toConvert) {
        return Integer.parseInt(toConvert);
    }

    /**
     * 주어진 문자열을 파싱하여 리스트에 담아 반환한다.
     * 파싱할 때 기준은 InputConfiguration에 DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER로 정의돼 있다.
     * @param toConvert 파싱할 문자열. 복수의 개별 정수들을 DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER로 구분한다.
     *                  오직 정수와 DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER로만 이루어져야 한다.
     *                  DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER는 문자열 맨 앞에 올 수 없다.
     * @return DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER를 기준으로 파싱된 정수들이 담긴 리스트.
     */
    public static List<Integer> convertWinningNumbers(String toConvert) {
        return Arrays.stream(toConvert.split(InputConfiguration.DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER))
                .map(Integer::parseInt).toList();
    }
}
