package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import lotto.util.RandomChoice;

public class User {
    List<Lotto> lotto = new ArrayList<>();
    private final int ticketCount;

    public User(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public void setLotto() {
        for (int i = 0; i < getTicketAmount(); i++) {
            Lotto ticket = new Lotto(RandomChoice.createLottoNumbers());
            lotto.add(ticket);
        }
    }

    public int getTicketAmount() {
        return ticketCount;
    }

    public List<Lotto> getLottoList() {
        return lotto;
    }

}
