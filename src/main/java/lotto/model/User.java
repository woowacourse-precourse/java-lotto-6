package lotto.model;

import java.util.List;
import lotto.Lotto;

public class User {

    private int amount;
    private int count;
    private List<Lotto> lottoTickets;

    public User(int amount) {
        this.amount = amount;
        this.count /= 1_000;
        lottoTickets = new java.util.ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoTickets.add(lotto);
    }
}
