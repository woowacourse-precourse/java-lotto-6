package lotto;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_LENGTH("당첨 번호 6자리를 입력해 주세요."),
    INVALID_DUPLICATE_NUMBER("중복되지 않는 당첨 번호 6자리를 입력해 주세요."),
    INVALID_CONTAIN_NOT_ONLY_NUMBER("숫자만 입력해 주세요."),
    INVALID_PURCHASE_PRICE_UNIT("로또 한 장의 구입금액은 1000원 입니다."),
    INVALID_PURCHASE_PRICE_RANGE("복권 및 복권기 금법 제5조(판매제한 등)에 따라 10만원을 초과해서 구입할 수 없습니다."),
    INVALID_WINNING_NUMBER_SEPARATOR("당첨 번호는 공백 없이 쉽표로 구분해 입력해 주세요. 예: 1,2,3,4,5,6")
    ;

    ErrorMessage(String message) {
        this.message = message;
    }

    public final String message;
}
