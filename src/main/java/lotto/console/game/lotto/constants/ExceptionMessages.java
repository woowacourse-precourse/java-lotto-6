package lotto.console.game.lotto.constants;

public class ExceptionMessages {
    public static String ERROR_PREFIX = "[ERROR] ";
    public static String ERROR_POSTFIX = "\n다시 입력해주세요.";

    public static final String INVALID_NOT_INTEGER = "입력값이 정수가 아닙니다";
    public static final String INVALID_NOT_MULTIPLE_THOUSAND = "입력값이 천의 배수가 아닙니다";
    public static final String INVALID_OUT_OF_RANGE_NUMBER = "입력값이 로또 번호의 범위를 벗어납니다";
    public static final String INVALID_WRONG_SEPERATOR = "번호는 쉼표(,)를 기준으로 구분되어야 합니다";
    public static final String INVALID_WINNING_NUMBER_COUNT = "당첨 번호는 6개여야 합니다";


    public static String makeErrorMessage(String error, String parameter) {
        return ERROR_PREFIX + error +  GameConstants.DELIMITER + parameter + ERROR_POSTFIX;
    }
}
