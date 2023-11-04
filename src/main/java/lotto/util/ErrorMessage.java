package lotto.util;

public enum ErrorMessage {
    ERROR_INFO("[ERROR] "),
    MONEY_ERROR("구매 금액은 1000원 단위의 숫자를 입력해 주세요. ex) 5000"),

    LOTTO_STRING_ERROR("로또 번호에 문자열이 들어올 수 없습니다."),
    LOTTO_SIZE_ERROR("로또 번호는 총 6자리여야 합니다."),
    LOTTO_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_UNIQUE_ERROR("로또 번호 간 중복이 있습니다."),


    LOTTO_BONUS_STRING_ERROR("보너스 번호에 문자열이 들어올 수 없습니다."),
    LOTTO_BONUS_RANGE_ERROR("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
