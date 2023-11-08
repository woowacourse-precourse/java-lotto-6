package lotto.exception.budget;

public class BudgetRangeException extends IllegalArgumentException{
    private static final String ERROR_MSG = "[ERROR] 금액은 최소 1000원 이상이어야 합니다.";

    public BudgetRangeException() {
        super(ERROR_MSG);
    }
}
