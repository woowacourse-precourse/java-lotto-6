package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private final List<Lotto> winningLotto;
    private final int amount;

    public Tickets(int amount) {
        this.winningLotto = new ArrayList<>();
        this.amount = amount;
    }

    public void add(Lotto lotto) {
        winningLotto.add(lotto);
    }

    public int calcTicketCount() {
        return amount / 1000;
    }

    public void printWinningLotto() {
        for(Lotto lotto: winningLotto) {
            lotto.printNumbers();
        }
    }

    // validate
}
