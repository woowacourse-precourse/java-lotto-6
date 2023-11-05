package lotto.dto.response;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsDto {
    private final List<String> lottoTickets;

    public LottoTicketsDto(List<Lotto> lottos) {
        this.lottoTickets = lottos.stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")))
                .collect(Collectors.toList());
    }

    public List<String> getLottoTickets() {
        return lottoTickets;
    }
}
