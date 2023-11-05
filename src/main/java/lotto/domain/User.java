package lotto.domain;

import lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class User {

    private final List<Lotto> tickets;

    private User(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static User of(List<Lotto> tickets) {
        return new User(tickets);
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
}
