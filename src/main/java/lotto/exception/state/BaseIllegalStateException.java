package lotto.exception.state;

public class BaseIllegalStateException extends IllegalStateException {
    public static final String ERROR_PREFACE = "[ERROR] ";

    public BaseIllegalStateException(String message) {
        super(ERROR_PREFACE + message);
    }

}
