package lotto;

public enum ErrorMessage {

    UNDER_1000_ERROR_MESSAGE("[ERROR] 1000원 이상의 금액을 입력해주세요."),
    ONLY_INTEGER_ERROR_MESSAGE("[ERROR] 숫자만 입력해주세요."),
    RANGE_1_45_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER_ERROR_MESSAGE("[ERROR] 중복되지 않는 숫자로 입력해주세요."),
    NUMBER_6_ESCAPE_ERROR_MESSAGE("[ERROR] 6개의 숫자만 입력해주세요"),
    NUMBER_1_ESCAPE_ERROR_MESSAGE("[ERROR] 1개의 숫자만 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
