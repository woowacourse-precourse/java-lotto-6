package lotto.model;

import java.util.List;
import lotto.util.Constants;

public class User {

    private int amount;
    private int count;
    private List<Lotto> lottoTickets;

    public User(int amount) {
        this.amount = amount;
        this.count = amount / Constants.LOTTO_PURCHASE_UNIT;
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
