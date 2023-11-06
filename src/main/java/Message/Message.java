package Message;

public enum Message {
    moneyOutOfRange(-1, "[ERROR] 구입 금액은 정수여야 합니다."),
    moneyInvalidFormat(-2, "[ERROR] 구입 금액은 1000원 단위의 양의 정수여야 합니다."),
    numberIncorrectFormat(-1, "[ERROR] 로또 번호는 공백없이 콤마(,)로 구분해서 입력해주세요."),
    numberOutOfRange(-2, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    numberIncorrectLength(-3, "[ERROR] 로또 번호는 6자리를 입력해주셔야 합니다."),
    numberIncorrect(-4, "[ERROR] 로또 번호는 정수로 입력해주세요.");
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
