package lotto;

public enum ErrorMessages {
    INVALID_LONG("[ERROR] 정수값을 입력해주세요."),
    INVALID_DIVIDE_NUMBER("[ERROR] 1,000으로 나누어 떨어지는 값을 입력해주세요."),
    INVALID_SIZE("[ERROR] 당첨 번호가 6개가 아닙니다."),
    INVALID_DUPLICATION("[ERROR] 중복된 수 발견."),
    INVALID_RANGE("[ERROR] 로또번호는 1~45까지 입니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
