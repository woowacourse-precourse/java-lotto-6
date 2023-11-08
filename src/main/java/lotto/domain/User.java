package lotto.domain;

import java.util.Collections;
import java.util.List;

public class User {
    private int budget;
    private int payed;
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
        payed = budget;
        budget = 0;
        return payed;
    }

    public int getBudget() {
        return budget;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getPayed() {
        return payed;
    }
}