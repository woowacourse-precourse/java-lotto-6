package lotto.dto;

import lotto.domain.model.lotto.Lotto;
import lotto.domain.model.lotto.LottoNumber;
import lotto.domain.model.lotto.LottoTickets;

import java.util.List;

public class LottoTicketsDto {
    private final List<List<Integer>> lottos;
    private final Integer totalTickets;

    public LottoTicketsDto(List<List<Integer>> lottos, Integer totalTickets) {
        this.lottos = lottos;
        this.totalTickets = totalTickets;
    }

    public static LottoTicketsDto from(LottoTickets lottoTickets) {
        List<List<Integer>> lottos = lottoTickets.getLottos()
                .stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(LottoNumber::getNumber)
                        .toList())
                .toList();
        return new LottoTicketsDto(lottos, lottoTickets.getSize());
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public int getTotalTickets() {
        return totalTickets;
    }
}
