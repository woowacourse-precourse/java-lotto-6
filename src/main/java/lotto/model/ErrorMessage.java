package lotto.model;

public enum ErrorMessage {
    ILLEGAL_NUMBER_FORMAT("[ERROR] 숫자 외의 문자를 입력할 수 없습니다."),
    DUPLICATED_NUMBER("[ERROR] 로또 당첨 번호는 중복 될 수 없습니다."),
    INSUFFICIENT_PURCHASE_AMOUNT("[ERROR] 로또 구입 금액은 최소 1000 원 이상 이여야 합니다."),
    ILLEGAL_NUMBER_SIZE("[ERROR] 6 개의 숫자를 입력해주세요."),
    ILLEGAL_NUMBER_RANGE("[ERROR] 로또 번호는 1 에서 45 사이의 숫자 여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
