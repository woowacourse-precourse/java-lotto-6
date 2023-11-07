package common.enumtype;

public enum ErrorCode {

    // Common
    NOT_NUMBER_STRING("공백없이 숫자를 입력해 주세요."),

    // LottoPurchaseAmount
    AMOUNT_LESS_THAN_MINIMUM("1,000원 이상의 로또 구입 금액을 입력해 주세요."),
    AMOUNT_INVALID_UNIT("로또 구입 금액은 1,000원 단위로 입력해 주세요."),

    // WinningNumber
    WINNING_NUMBER_INVALID_RANGE("당첨 번호는 1 이상 45 이하의 숫자를 입력해 주세요."),

    // WinningNumbers
    WINNING_NUMBERS_INVALID_SIZE("당첨 번호는 6개의 숫자를 입력해 주세요."),
    WINNING_NUMBERS_DUPLICATED("당첨 번호는 중복되지 않는 숫자를 입력해 주세요."),
    WINNING_NUMBERS_CONTAIN_BONUS_NUMBER("당첨 번호와 중복되지 않는 보너스 번호를 입력해 주세요."),
    BONUS_NUMBER_ALREADY_REGISTERED("보너스 번호는 이미 등록된 상태입니다."),

    // Lotto
    LOTTO_NUMBERS_INVALID_SIZE("로또 번호는 6자리 숫자여야 합니다."),
    LOTTO_NUMBERS_INVALID_RANGE("로또 번호는 1 이상 45 이하의 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 번호는 중복되지 않는 숫자여야 합니다."),
    ;

    private static final String PREFIX_ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX_ERROR_MESSAGE + message;
    }
}
