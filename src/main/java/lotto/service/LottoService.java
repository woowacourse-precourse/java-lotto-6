package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ticket;
import lotto.utils.RandomNumberGenerator;

public class LottoService {

    private final RandomNumberGenerator randomNumberGenerator;

    public LottoService(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Ticket calculateTicketFromAmonut(final Amount amount) {
        return new Ticket(amount.divideByThousand());
    }

    public Lottos saveLottos(Ticket ticket) {
        List<Lotto> elements = Stream.generate(() -> new Lotto(randomNumberGenerator.generateUniqueSortedNumbers()))
                .limit(ticket.toValue())
                .toList();
        return new Lottos(elements);
    }


}
