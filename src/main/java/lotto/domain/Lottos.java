package lotto.domain;

import lotto.domain.dto.output.LottoDto;
import lotto.domain.dto.output.LottosDto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoTickets;

    private Lottos(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static Lottos from(List<Lotto> lottoTickets) {
        return new Lottos(lottoTickets);
    }

    public LottosDto toLottosDto() {
        List<LottoDto> lottoNumbers = lottoTickets.stream()
                .map(Lotto::toLottoDto)
                .toList();
        return new LottosDto(lottoNumbers, lottoTickets.size());
    }
}
