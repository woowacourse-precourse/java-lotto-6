package lotto.domain;

public class Validator {
    private int cost;

    public void validateCost(String cost) {
        parseToInt(cost);
        isPositive();
        isPerThousand();
    }

    private void parseToInt(String cost) {
        try {
            this.cost = Integer.parseInt(cost);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("구입 금액 숫자로 해야하는 에러");
            throw new IllegalArgumentException();
        }
    }

    private void isPositive() {
        try {
            if (this.cost < 1000) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("음수이거나 값이 너무 작은 문제");
            throw new IllegalArgumentException();
        }
    }

    private void isPerThousand() {
        try {
            if (this.cost % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("천원 단위로 안나눠지는 에러");
            throw new IllegalArgumentException();
        }
    }
}

