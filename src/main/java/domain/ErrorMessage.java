package domain;

public enum ErrorMessage {
    INVALID_AMOUNT("[ERROR] 구입금액은 1000원 단위로 입력해주세요."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자를 입력해 주세요."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_INPUT_CNT("[ERROR] 로또 번호는 6개를 입력해야 합니다."),
    INVALID_NUMBER_DUPLICATE("[ERROR] 로또 번호는 6개를 입력해야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}