package lotto;

public enum ErrorMessage {
    NUMBER_OVER_LIMIT("[ERROR] 숫자는 45를 넘기면 안됩니다."),
    PURCHASE_NOT_DIVIDE_BY_1000("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다."),
    CONTAINS_NON_NUMERIC_CHARACTERS("[ERROR] 숫자만을 입력해야 합니다."),
    NUMBERS_SIZE_IS_NOT_6("[ERROR] 로또는 6개의 숫자로 이루어저야 합니다."),
    HAS_DUPLICATE_NUMBER("[ERROR] 중복되는 숫자가 존재합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
