package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.NumberGenerator;
import lotto.vo.TicketCount;

public class Player {

    private final List<Lotto> lotteries;

    private Player(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Player createPlayer(final TicketCount ticketCount, final NumberGenerator numberGenerator) {
        List<Lotto> lotteries = IntStream.range(0, ticketCount.count())
                .mapToObj(eachTicket -> Lotto.createPlayerLotto(numberGenerator))
                .toList();
        return new Player(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
