package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private static final int STANDARD_OF_DIVIDE = 1000;
    private final List<Lotto> tickets;

    private LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(int purchasePrice, NumberGenerator lottoNumberGenerator) {
        int purchaseCount = calculatePurchaseCount(purchasePrice);
        return new LottoTickets(createPurchasedLottos(purchaseCount, lottoNumberGenerator));
    }

    private static int calculatePurchaseCount(int purchasePrice) {
        return purchasePrice / STANDARD_OF_DIVIDE;
    }

    private static List<Lotto> createPurchasedLottos(int purchaseCount, NumberGenerator lottoNumberGenerator) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public int getTicketCount() {
        return tickets.size();
    }
}
