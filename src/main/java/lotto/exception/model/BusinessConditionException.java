package lotto.exception.model;

public class BusinessConditionException extends IllegalArgumentException {
    public BusinessConditionException(String message) {
        super(message);
    }
}
