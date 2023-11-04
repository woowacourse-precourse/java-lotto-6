package util;

public enum ErrorMessage {

    PRICE_ISNT_MULTIPLE_OF_THOUSAND_WON("[ERROR] 구매 금액이 천원 단위가 아닙니다. 구매 금액은 천원 단원로 입력해 주세요."),
    PRICE_CONTAIN_NON_NUMERIC_CHARACTER("[ERROR] 구매 금액은 숫자만 입력해 주세요."),
    PRICE_IS_NEGATIVE("[ERROR] 구매 금액은 0 이상인 정수만 입력해 주세요."),
    LOTTO_CONTAIN_DULPICATE_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다. 중복되지 않은 숫자를 입력해 주세요."),
    OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
