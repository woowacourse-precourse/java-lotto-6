package lotto.util;

public enum ErrorMessage {
    ERROR_INFO("ERROR "),
    MONEY_ERROR("구매 금액은 1000원 단위의 숫자를 입력해 주세요. ex) 5000"),
    LOTTO_SIZE_ERROR("로또 번호 개수가 6개를 벗어났습니다."),
    LOTTO_RANGE_ERROR("로또 번호의 범위가 1~45를 벗어났습니다."),
    LOTTO_UNIQUE_ERROR("로또 번호 간 중복이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
