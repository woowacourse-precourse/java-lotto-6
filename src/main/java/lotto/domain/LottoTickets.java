package lotto.domain;

import static lotto.utils.Randoms.pickUniqueNumbersInRange;

import java.util.List;
import java.util.stream.IntStream;

public class LottoTickets {

    private final List<Lotto> tickets;

    private LottoTickets(final List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(int count) {
        List<Lotto> result = createTickets(count);
        return new LottoTickets(result);
    }

    private static List<Lotto> createTickets(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> new Lotto(pickUniqueNumbersInRange()))
                .toList();
    }

    public List<String> receiveLottoTicketsInfo() {
        return tickets.stream()
                .map(Lotto::toString)
                .toList();
    }
}
