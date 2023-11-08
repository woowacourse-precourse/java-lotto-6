package lotto.model;

import java.util.List;

public class User {

    private int amount;
    private List<Lotto> lottos;
    private List<Integer> ranks;

    public User(int amount, List<Lotto> lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public void setRank(List<Integer> ranks) {
        this.ranks = ranks;
    }

    public List<Integer> getRanks() {
        return this.ranks;
    }

    public int getUserAmount() {
        return this.amount;
    }

    public List<Lotto> getUserLottos() {
        return this.lottos;
    }

}
