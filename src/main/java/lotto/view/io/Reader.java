package lotto.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.LottoGameException;

/**
 * 일반적인 입력 처리 기능을 제공합니다.
 */
public class Reader {

    /**
     * @return 숫자 하나를 입력 받아 반환합니다.
     * @throws IllegalArgumentException - 숫자 형식의 입력이 아닌 경우
     */
    public static int getOneNumber() {
        String input = Console.readLine();
        return parseInt(input);
    }

    /**
     * 주어진 패턴의 입력을 받아 숫자 리스트를 반환합니다.
     *
     * @param preprocessor - 입력에 대한 전처리 로직
     * @param pattern      - 입력되어야 할 패턴에 대한 Regex
     * @param delimiter    - 각 숫자를 구분할 구분자
     * @return 입력된 숫자들을 담은 List 반환
     * @throws IllegalArgumentException - 입력이 패턴과 맞지 않을 경우
     */
    public static List<Integer> getNumbersInPattern(
            Function<String, String> preprocessor,
            Pattern pattern,
            String delimiter) {

        String input = getStringInPattern(preprocessor, pattern);
        return Arrays.stream(input.split(delimiter))
                .map(Reader::parseInt)
                .toList();
    }

    /**
     * 주어진 Regex 패턴에 해당하는 입력 문자열을 반환합니다.
     *
     * @param preprocessor - 입력에 대한 전처리 로직
     * @param pattern      - 입력되어야 할 패턴에 대한 Regex
     * @return 패턴에 해당하는 문자열
     * @throws IllegalArgumentException - 입력이 패턴과 맞지 않을 경우
     */
    public static String getStringInPattern(
            Function<String, String> preprocessor,
            Pattern pattern) {
        String input = Console.readLine();
        String afterProcessing = preprocessor.apply(input);
        validateAnswersFormat(afterProcessing, pattern);

        return afterProcessing;
    }

    private static void validateAnswersFormat(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw LottoGameException.WRONG_ANSWERS_FORMAT.makeException();
        }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw LottoGameException.WRONG_NUMBER_FORMAT.makeException();
        }
    }
}
