package lotto;

public enum Messages {
    ERROR_MESSAGE_START("[ERROR]"),
    ERROR_INPUT_NUMBER("숫자를 입력하세요"),
    ERROR_RANGE("입력 금액은 1000원 단위여야 합니다."),
    ERROR_LOTTO_NUMBER("로또 번호는 6개입니다."),
    ERROR_LOTTO_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_LOTTO_DUPLE("로또 번호에 중복된 번호가 있습니다.");

    private String message;

    Messages(String s) {
        message=s;
    }

    public String getMessage() {
        return this.message;
    }
}
