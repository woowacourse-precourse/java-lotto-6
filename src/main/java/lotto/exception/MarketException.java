package lotto.exception;

public class MarketException extends RuntimeException {
    public static final String ERROR = "[ERROR] ";

    public MarketException(String message) {
        super(ERROR + message);
    }
}
