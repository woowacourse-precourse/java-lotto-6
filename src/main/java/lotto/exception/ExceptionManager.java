package lotto.exception;

public enum ExceptionManager {

    ERROR_MSG_PREFIX("[ERROR] ");

    private final String msg;

    ExceptionManager(String msg) {
        this.msg = msg;
    }

    public IllegalArgumentException createIllegalArgumentException(String detailMsg) {
        return new IllegalArgumentException(msg + detailMsg);
    }
}
