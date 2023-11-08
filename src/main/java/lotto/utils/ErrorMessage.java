package lotto.utils;

public enum ErrorMessage {
    INVALID_LOTTO_SIZE("[ERROR] 6자리의 숫자를 입력해 주세요."),
    INVALID_INT_RANGE("[ERROR] 너무 큰 금액입니다."),
    INVALID_DIVISIBLE("[ERROR] 1000원 단위의 입력이 아닙니다."),
    INVALID_LOTTO_RANGE("[ERROR] 로또 번호는 1~45 사이의 숫자입니다."),
    INVALID_DUPLICATE("[ERROR] 로또 번호에 중복이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
