package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.vo.TicketCount;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries createLotteries(final TicketCount ticketCount,
                                            final LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lotteries = IntStream.range(0, ticketCount.count())
                .mapToObj(eachTicket -> Lotto.createLotto(lottoNumberGenerator))
                .toList();

        return new Lotteries(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
