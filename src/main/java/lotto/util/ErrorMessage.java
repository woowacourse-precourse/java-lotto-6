package lotto.util;

public class ErrorMessage {
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야합니다. 다시 입력해주세요.";
    private static final String LOTTO_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야합니다. 다시 입력해주세요.";
    private static final String AMOUNT_NOT_MULTIPLE_OF_1000_ERROR_MESSAGE = "[ERROR] 로또 구매 금액은 1,000원으로 나누어 떨어져야합니다. 다시 입력해주세요.";
    private static final String WINNING_NUMBERS_DELIMITER_NOT_COMMA_ERROR_MESSAGE = "[ERROR] 로또 번호는 쉼표(,)를 기준으로 구분된 숫자여야합니다. 다시 입력해주세요.";
    private static final String BONUS_IN_LOTTO_ERROR_MESSAGE = "[ERROR] 보너스 번호가 당첨 번호 안에 포함되지 않아야 합니다. 다시 입력해주세요.";
    private static final String INPUT_BLANK_ERROR_MESSAGE = "[ERROR] 입력 값이 비어있습니다. 다시 입력해주세요.";
    private static final String INPUT_NOT_NATURAL_ERROR_MESSAGE = "[ERROR] 입력 값은 자연수여야합니다. 다시 입력해주세요.";
    private static final String INPUT_NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 입력 값은 숫자여야합니다. 다시 입력해주세요.";
    private static final String INPUT_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 숫자의 범위는 " + Constants.MIN_NUMBER + "부터 " + Constants.MAX_NUMBER + "사이의 값입니다. 다시 입력해주세요.";

    public static void printDuplicateMessage() {
        printExceptionMessage(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }
    public static void printSizeErrorMessage() {
        printExceptionMessage(LOTTO_NUMBER_SIZE_ERROR_MESSAGE);
    }
    public static void printNotDivisionErrorMessage() {
        printExceptionMessage(AMOUNT_NOT_MULTIPLE_OF_1000_ERROR_MESSAGE);
    }
    public static void printDelimiterIsNotCommaErrorMessage() {
        printExceptionMessage(WINNING_NUMBERS_DELIMITER_NOT_COMMA_ERROR_MESSAGE);
    }
    public static void printBonusIncludedErrorMessage() {
        printExceptionMessage(BONUS_IN_LOTTO_ERROR_MESSAGE);
    }
    public static void printBlankInputErrorMessage() {
        printExceptionMessage(INPUT_BLANK_ERROR_MESSAGE);
    }
    public static void printNotNaturalNumberErrorMessage() {
        printExceptionMessage(INPUT_NOT_NATURAL_ERROR_MESSAGE);
    }
    public static void printNotNumericNumberErrorMessage() {
        printExceptionMessage(INPUT_NOT_NUMERIC_ERROR_MESSAGE);
    }
    public static void printOutOfRangeNumberErrorMessage() {
        printExceptionMessage(INPUT_OUT_OF_RANGE_ERROR_MESSAGE);
    }
    private static void printExceptionMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
