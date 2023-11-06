package lotto.domain;

public class CostValidator {
    private int cost;
    public CostValidator() {
    }

    public void validateCost(String cost) {
        parseToInt(cost);
        isPositive();
        isPerThousand();
    }

    private void parseToInt(String cost) {
        try {
            this.cost = Integer.parseInt(cost);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("구입 금액 숫자로 해야하는 에러");
        }
    }

    private void isPositive() {
        if (this.cost < 1000) {
            throw new IllegalArgumentException("음수이거나 값이 너무 작은 문제");
        }
    }

    private void isPerThousand() {
        if (this.cost % 1000 != 0) {
            throw new IllegalArgumentException("천원 단위로 안나눠지는 에러");
        }
    }
}

