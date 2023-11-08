package lotto.model;

import java.util.List;

public class User {

    private int amount;
    private int count;
    private List<Lotto> lottoTickets;

    public User(int amount) {
        this.amount = amount;
        this.count = amount / 1_000;
        lottoTickets = new java.util.ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
