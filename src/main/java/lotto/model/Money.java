package lotto.model;

public class Money {
    private static final int MIN_COST = 1000;
    private static final int MAX_COST = 100000;
    private int cost;

    public Money(int cost) {
        validateCostOutOfSize(cost);
        validateCostInUnit(cost);
        this.cost = cost;
    }

    public int getMoney() {
        return cost;
    }

    public int getLottoCount() {
        return cost / MIN_COST;
    }

    private void validateCostOutOfSize(int cost) {
        if (cost < MIN_COST || cost > MAX_COST) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상 100,000원 이하로만 가능합니다");
        }
    }

    private void validateCostInUnit(int cost) {
        if (cost % MIN_COST != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로만 가능합니다");
        }
    }
}
