package lotto.validator.domain.exception;

public class DomainIllegalArgumentException extends IllegalArgumentException {

    public DomainIllegalArgumentException(final DomainExceptionMessage message) {
        super(message.value());
    }
}
