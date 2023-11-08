package lotto.Constants;

public enum BudgetConstants {
    ZERO_BUDGET(0),
    MINIMUM_BUDGET(1000),
    MAXIMUM_BUDGET(1000000000),
    BUDGET_UNIT(1000);

    private int price;
    BudgetConstants(int price){
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
