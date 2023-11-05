package lotto.utils.validator;

public class ParserValidator {
    public static void commaValid(final String winnerNumbers) throws IllegalArgumentException{
        if (startCheck(winnerNumbers) || endCheck(winnerNumbers)
                || doubleCommaCheck(winnerNumbers)) {
            throw new IllegalArgumentException("콤마(,) 의 위치가 이상합니다. 입력을 다시 확인해주세요.");
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
}
