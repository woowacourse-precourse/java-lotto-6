package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Lotto> lotto;
    private Cost cost;

    public Player(String cost) {
        this.cost = new Cost(cost);
        lotto = new ArrayList<>();
    }

    public List<Lotto> getLotto() {
        return this.lotto;
    }

    public Cost getCost() {
        return this.cost;
    }
}