package lotto.script;

public enum Error {
    Error("[ERROR] 숫자를 입력하세요.");

    public final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
