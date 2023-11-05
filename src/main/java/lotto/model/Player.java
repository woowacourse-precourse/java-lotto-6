package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.NumberGenerator;
import lotto.vo.TicketQuantity;

public class Player {

    private final List<Lotto> lotteries;

    private Player(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Player createPlayer(final TicketQuantity ticketQuantity, final NumberGenerator numberGenerator) {
        List<Lotto> lotteries = IntStream.range(0, ticketQuantity.quantity())
                .mapToObj(i -> Lotto.createPlayerLotto(numberGenerator))
                .toList();
        return new Player(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
