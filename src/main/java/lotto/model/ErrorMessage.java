package lotto.model;

public enum ErrorMessage {

    INVALID_PURCHASE_AMOUNT_NUMBER("[ERROR] 1000원 이상 100000원 이하의 값을 입력해주세요"),
    INVALID_PURCHASE_AMOUNT_CHARACTER("[ERROR] 문자를 입력하셨습니다."),
    INVALID_AMOUNT_UNIT("[ERROR] 1000원 단위의 값을 입력해주세요"),
    INVALID_LOTTO_NUMBER("[ERROR] 숫자로만 이루어진 6자리를 입력하세요"),
    INVALID_LOTTO_NUMBER_DUPLICATION("[ERROR] 중복인 숫자를 입력하셨습니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 1부터 45사이의 6개의 숫자를 입력해주세요");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
