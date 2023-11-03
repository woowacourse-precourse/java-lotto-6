package lotto.constant;

public enum ExceptionMessage {

    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개 입니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호가 중복되어 생성되었습니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NON_NUMERIC_ERROR("[ERROR] 숫자만 입력할 수 있습니다."),
    INSUFFICIENT_PRICE_TO_BUY("[ERROR] 로또 복권 금액을 살 수 없는 금액입니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
