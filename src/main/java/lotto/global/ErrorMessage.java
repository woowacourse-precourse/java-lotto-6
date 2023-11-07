package lotto.global;

public enum ErrorMessage {
    SIZE_ERROR("[ERROR] 로또 번호를 6개 입력 해주세요."),
    PAYMENT_ERROR("[ERROR] 지불 금액은 1000원 단위로 입력해주세요."),
    NUMBER_ERROR("[ERROR] 숫자로 입력해주세요."),
    RANGE_ERROR("[ERROR] 1~45 사이의 숫자로 입력해주세요"),
    DUPLICATE_NUMBER("[ERROR] 중복된 값을 입력할 수 없습니다."),
    ERROR_MESSAGE("[ERROR] 잘못된 입력");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
