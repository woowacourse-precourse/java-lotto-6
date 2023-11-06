package lotto.domain;

public class User {
    private int budget;

    private User(int budget) {
        this.budget = budget;
    }

    public static User createByBudget(int budget) {
        return new User(budget);
    }

    public void setBudget(int money) {
        this.budget = money;
    }
}