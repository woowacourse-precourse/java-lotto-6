package lotto.exception.business;

public class BusinessConditionException extends IllegalArgumentException {
    public BusinessConditionException(String message) {
        super(message);
    }
}
