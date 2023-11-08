package lotto.utils.validator;

import java.util.List;

public class ParserValidator {
    public static int LOTTO_COUNT_MAXIMUM_UNIT = 6;
    public static void commaValid(final String winnerNumbers) throws IllegalArgumentException{
        if (startCheck(winnerNumbers) || endCheck(winnerNumbers)
                || doubleCommaCheck(winnerNumbers)) {
            throw new IllegalArgumentException("콤마(,) 의 위치가 이상합니다. 입력을 다시 확인해주세요.");
        }
    }
    public static void countValid(final List<Integer> integerNumbers) throws IllegalArgumentException{
        if (countCheck(integerNumbers)) {
            throw new IllegalArgumentException("로또 추첨 번호는 6개 입니다. 6개를 올바르게 입력해주세요.");
        }
    }
    private static boolean doubleCommaCheck(final String winnerNumbers) {
        return winnerNumbers.contains(",,") || winnerNumbers.contains(", ,");
    }
    private static boolean endCheck(final String winnerNumbers) {
        return winnerNumbers.endsWith(",") || winnerNumbers.endsWith(", ");
    }
    private static boolean startCheck(final String winnerNumbers) {
        return winnerNumbers.startsWith(" ") || winnerNumbers.startsWith(",");
    }
    private static boolean countCheck(final List<Integer> integerNumbers) {
        return integerNumbers.size() != LOTTO_COUNT_MAXIMUM_UNIT;
    }
}
