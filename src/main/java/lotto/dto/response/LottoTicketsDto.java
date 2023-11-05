package lotto.dto.response;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsDto {
    private final Lottos lottoTickets;

    private LottoTicketsDto(Lottos lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTicketsDto from(Lottos lottoTickets) {
        return new LottoTicketsDto(lottoTickets);
    }

    public List<String> getFormattedLottoTickets() {
        return lottoTickets.getLottoTickets().stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")))
                .collect(Collectors.toList());
    }
}
