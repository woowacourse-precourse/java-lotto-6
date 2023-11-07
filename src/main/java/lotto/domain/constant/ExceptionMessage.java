package lotto.domain.constant;

public enum ExceptionMessage {
    DUPLICATE_LOTTO_NUMBER("중복된 숫자는 입력하실 수 없습니다."),
    DUPLICATE_BONUS_NUMBER("입력하신 로또 숫자와 중복된 보너스 숫자는 입력하실 수 없습니다."),
    INVALID_RANGE_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_LOTTO_SIZE("6자리 숫자를 입력해주세요."),
    INVALID_RANGE_MONEY("유효하지 않은 구매 금액 범위입니다."),
    NOT_BLANK("공백이 아닌 숫자를 입력해주세요."),
    INCLUDE_CHAR("문자를 제외한 숫자를 입력해주세요"),
    INVALID_UNIT_MONEY("구매 금액 단위에 맞게 입력해주세요.");


    private static final String ERROR = "[ERROR] ";
    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = ERROR + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
