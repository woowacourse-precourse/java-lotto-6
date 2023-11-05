package lotto.utils;

public class InputValidator {
    private static final int MIN_COST = 1000;
    private static final int MAX_COST = 100000;

    public void validatePurchaseCostInputView(String cost) {
        validateInputBlank(cost);
        validateInputInt(cost);
        validateCostOutOfSize(cost);
        validateCostInUnit(cost);
    }

    private void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[Error] 빈 값을 입력할 수 없습니다");
        }
    }

    private void validateInputInt(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[Error] 정수가 아닌 다른 문자는 입력할 수 없습니다");
        }
    }

    private void validateCostOutOfSize(String cost) {
        int intCost = Integer.parseInt(cost);
        if (intCost < MIN_COST || intCost > MAX_COST) {
            throw new IllegalArgumentException("[Error] 구매 금액은 1000원 이상 100,000원 이하로만 가능합니다");
        }
    }

    private void validateCostInUnit(String cost) {
        int intCost = Integer.parseInt(cost);
        if (intCost % MIN_COST != 0) {
            throw new IllegalArgumentException("[Error] 구매 금액은 1000원 단위로만 가능합니다");
        }
    }
}
