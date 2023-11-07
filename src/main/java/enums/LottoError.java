package enums;

public enum LottoError {
    NUMBER_FORMAT_ERROR("로또 번호는 숫자로만 이루어져야 합니다."),
    NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_COUNT_ERROR("로또 번호는 6자리로 구성되어있어야 합니다."),
    NUMBER_DUPLICATE_ERROR("로또 당첨 번호는 중복된 값이 입력될 수 없습니다."),
    LOTTO_BUY_MIN_MONEY_ERROR("로또를 구매하기 위한 최소 금액은 1,000원 입니다."),
    LOTTO_BUY_CORRECT_ERROR("로또를 구매하기 위해서는 1,000원의 배수로 입력해야합니다."),
    LOTTO_BLANK_ERROR("로또 당첨 번호에 공백이 입력될 수 없습니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    LottoError(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
