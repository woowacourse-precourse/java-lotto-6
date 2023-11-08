package lotto.dto.response;

import lotto.model.Lottos;
import lotto.model.Money;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsDto {
    private final Lottos lottos;
    private final Money lottoCost;

    private LottoTicketsDto(Lottos lottos, Money lottoCost) {
        this.lottos = lottos;
        this.lottoCost = lottoCost;
    }

    public static LottoTicketsDto of(Lottos lottoTickets, Money lottoCost) {
        return new LottoTicketsDto(lottoTickets,lottoCost);
    }

    public List<List<String>> getFormattedLottoTickets() {
        return lottos.getLottoTickets().stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(Object::toString)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getLottoTicketCount() {
        return lottos.getLottoTickets().size();
    }

    public int getLottoCost() {
        return lottoCost.getAmount();
    }
}
