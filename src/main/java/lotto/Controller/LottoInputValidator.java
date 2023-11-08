package lotto.Controller;

public class LottoInputValidator {

    public void validateBudget(String budgetStr) throws Exception {
        Long budget;
        try {
            budget = Long.parseLong(budgetStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가아닙니다.");
        }
    }
}
