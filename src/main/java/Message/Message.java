package Message;

public enum Message {
    moneyOutOfRange(-1,"[ERROR] 구입 금액은 정수여야 합니다."),
    moneyInvalidFormat(-2,"[ERROR] 구입 금액은 1000원 단위의 양의 정수여야 합니다."),
    numberOutOfRange(-1,"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    numberInvalidFormat(-2,"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    private final int code;
    private final String message;

    Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
