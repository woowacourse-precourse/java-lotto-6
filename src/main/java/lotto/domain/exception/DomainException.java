package lotto.domain.exception;

public class DomainException extends IllegalArgumentException {

    protected DomainException(String message) {
        super(message);
    }

}
