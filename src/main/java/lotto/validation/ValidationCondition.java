package lotto.validation;

public abstract class ValidationCondition {
    protected final static String ERROR_MSG = "[ERROR] ";
    public abstract void isSatisfiedBy(String money);
}
