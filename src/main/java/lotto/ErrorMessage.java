package lotto;

public class ErrorMessage {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static final String CONTAINS_WHITESPACE = errorMessage("공백은 입력할 수 없습니다.");
    public static final String INVALID_NUMBER_FORMAT = errorMessage("숫자만 입력 가능합니다.");
    public static final String NEGATIVE_NUMBER = errorMessage("음수는 입력할 수 없습니다.");
    public static final String INVALID_PURCHASE_AMOUNT = errorMessage("로또 구입 금액은 1000원 단위로 입력 가능합니다.");
    public static final String ENDS_WITH_DELIMITER = errorMessage("구분자(,)로 끝날 수 없습니다.");
    public static final String INVALID_LOTTO_SIZE = errorMessage("로또 번호는 6개만 입력 가능합니다.");
    public static final String INVALID_LOTTO_NUMBER_RANGE = errorMessage("로또 번호는 1 ~ 45 사이의 숫자만 입력 가능합니다.");
    public static final String DUPLICATED_LOTTO_NUMBER = errorMessage("중복된 숫자를 입력할 수 없습니다.");
    public static final String DUPLICATED_BONUS_NUMBER = errorMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static String errorMessage(String message) {
        return ERROR_MESSAGE + message;
    }
}