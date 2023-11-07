package lotto;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_LENGTH("당첨 번호 6자리를 입력해 주세요."),
    INVALID_DUPLICATE_NUMBER("중복되지 않는 당첨 번호 6자리를 입력해 주세요.")
    ;

    ErrorMessage(String message) {
        this.message = message;
    }

    public final String message;
}
