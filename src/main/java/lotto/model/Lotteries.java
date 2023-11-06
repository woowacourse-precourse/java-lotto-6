package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.NumberGenerator;
import lotto.vo.TicketCount;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries createLotteries(final TicketCount ticketCount, final NumberGenerator numberGenerator) {
        List<Lotto> lotteries = IntStream.range(0, ticketCount.count())
                .mapToObj(eachTicket -> Lotto.createLotto(numberGenerator))
                .toList();
        
        return new Lotteries(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
