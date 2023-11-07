package lotto.system.shop.exception.machine;

public class AlreadyInitializeException extends IllegalStateException {

    public AlreadyInitializeException(String message) {
        super(message);
    }
}
