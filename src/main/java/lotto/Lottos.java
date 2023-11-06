package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> tickets;

    public Lottos(int size) {
        List<Lotto> tickets = new ArrayList<>();
        while (tickets.size() != size) {
            tickets.add(createTicket());
        }
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return this.tickets;
    }

    private Lotto createTicket() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }
}
