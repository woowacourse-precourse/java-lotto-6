package lotto;

public enum Error {
    PARSETOINTEGER("숫자만 입력 가능합니다."),
    UNIT("1,000 단위의 숫자만 입력 가능합니다."),
    WINNINGNUMBER("6자리의 숫자만 입력 가능합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println("[ERROR] " + message);
    }
}
