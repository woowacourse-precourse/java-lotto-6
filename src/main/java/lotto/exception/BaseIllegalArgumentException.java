package lotto.exception;

/**
 * 에러 양식에 맞추어 출력하도록 한다.
 * <p>
 * 에러 양식: "[ERROR] {{MESSAGE}}"
 */
public abstract class BaseIllegalArgumentException extends IllegalArgumentException {
    public static final String ERROR = "[ERROR] ";

    public BaseIllegalArgumentException(String message) {
        super(ERROR + message);
    }
}
