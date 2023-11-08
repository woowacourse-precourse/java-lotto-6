package lotto.domain.dto;

import lotto.domain.lotto.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {
    private List<LottoDto> lottos;

    private LottoTicketDto(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public static LottoTicketDto of(LottoTicket lottoTicket) {
        List<LottoDto> lottoDTOs = lottoTicket.getLottos().stream()
                .map(LottoDto::of)
                .collect(Collectors.toList());
        return new LottoTicketDto(lottoDTOs);
    }
}
