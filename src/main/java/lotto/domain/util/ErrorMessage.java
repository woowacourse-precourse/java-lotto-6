package lotto.domain.util;

public enum ErrorMessage {
    INVALID_TYPE_INPUT("[ERROR] 숫자를 입력해 주세요."),
    INVALID_MONEY_UNIT("[ERROR] 1000원 단위의 금액을 입력해 주세요."),
    INVALID_LENGTH_INPUT("[ERROR] 알맞은 개수의 번호를 입력해 주세요."),
    DUPLICATE_NUMBER("[ERROR] 중복되는 번호가 존재합니다."),
    INVALID_RANGE_NUMBER("[ERROR] 1-45 이내의 번호를 입력해 주세요."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 당첨 번호와 중복되는 번호입니다.")
    ;

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
