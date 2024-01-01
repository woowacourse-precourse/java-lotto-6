package lotto.model;

import java.util.List;
import java.util.Optional;

public class Lottos {

    private final List<Lotto> tickets;

    public Lottos(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public List<Optional<Rank>> check(WinningLotto winningLotto) {
        return tickets.stream()
                .map(lotto -> Rank.sort(lotto, winningLotto))
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto ticket : tickets) {
            sb.append(ticket).append("\n");
        }
        return sb.toString();
    }
}
