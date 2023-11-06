package lotto.dto.response;

import lotto.model.Lottos;
import lotto.model.Money;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsDto {
    private final Lottos lottoTickets;
    private final Money lottoCost;

    private LottoTicketsDto(Lottos lottoTickets, Money lottoCost) {
        this.lottoTickets = lottoTickets;
        this.lottoCost = lottoCost;
    }

    public static LottoTicketsDto of(Lottos lottoTickets, Money lottoCost) {
        return new LottoTicketsDto(lottoTickets,lottoCost);
    }

    public List<List<String>> getFormattedLottoTickets() {
        return lottoTickets.getLottoTickets().stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(Object::toString)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public Lottos getLottoTickets() {
        return lottoTickets;
    }

    public int getLottoTicketCount() {
        return lottoTickets.getLottoTickets().size();
    }

    public int getLottoCost() {
        return lottoCost.getAmount();
    }
}
