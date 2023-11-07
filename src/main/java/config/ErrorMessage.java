package config;

public enum ErrorMessage {

    LOTTO("[ERROR] 로또 번호는 중복 없는 6개 입니다."),
    BONUS("[ERROR] 보너스 번호는 당첨 번호와 중복 될 수 없습니다."),
    ONLY_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    PRICE("[ERROR] 금액은 천원 단위로 가능합니다."),
    RANGE("[ERROR] 가능한 숫자범위는 1-45 입니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
