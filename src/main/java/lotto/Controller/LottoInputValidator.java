package lotto.Controller;

public class LottoInputValidator {

    public void validateBudget(String budgetStr) throws Exception {
        Long budget;
        try {
            budget = Long.parseLong(budgetStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 숫자가아닙니다.");
        }
        if (budget <= 0 || budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 예산은 0보다 크고 1000으로 나누어 떨어져야 합니다.\n");
        }
    }
}
