package lotto.util.exception;

public enum ErrorMessage {
    BLANK_INPUT("[ERROR] 공백이 아닌 문자를 입력해주세요."),
    INVALID_NUMERIC_INPUT("[ERROR] 숫자로만 입력해주세요."),
    INVALID_LOTTO_COST_UNIT("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 당첨 번호의 숫자 범위는 1~45까지입니다."),
    INVALID_LOTTO_NUMBERS_SIZE("[ERROR] 당첨 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("[ERROR] 당첨 번호의 숫자는 중복되지 않아야 합니다."),
    CONTAIN_LOTTO_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
