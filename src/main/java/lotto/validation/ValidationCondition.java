package lotto.validation;

public abstract class ValidationCondition {
    private final static String EXCEPTION_MSG = "시스템 에러";
    protected final static String ERROR_MSG = "[ERROR] ";

    public void isSatisfiedBy(Object obj){
        if (!isObjectOf(obj)) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }

        validateCondition(obj);
    }

    protected abstract void validateCondition(Object obj);

    protected abstract boolean isObjectOf(Object obj);

}
