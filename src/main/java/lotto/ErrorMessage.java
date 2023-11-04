package lotto;

public enum ErrorMessage {
    LOTTO_SIZE("[ERROR] 로또는 6개의 숫자로 구성되어야 합니다."),
    NUMBER_DUPLICATE("[ERROR] 로또에 중복되는 숫자가 있습니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또에 범위를 벗어나는 숫자가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
