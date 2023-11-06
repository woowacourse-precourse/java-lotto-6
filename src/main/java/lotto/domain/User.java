package lotto.domain;

import java.util.List;

public class User {
    private int budget;
    private List<Lotto> lottos;

    private User(int budget) {
        this.budget = budget;
    }

    public static User createByBudget(int budget) {
        return new User(budget);
    }

    public void setBudget(int money) {
        this.budget = money;
    }

    // 전체 예산을 지불
    public int pay() {
        int money = budget;
        this.budget = 0;
        return money;
    }

    public int getBudget() {
        return budget;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}