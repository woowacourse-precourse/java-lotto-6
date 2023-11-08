package lotto.dto;

import java.util.List;

public class LottoTicketsDto {
    private final List<LottoDto> lottoTickets;

    public LottoTicketsDto(List<LottoDto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoDto> getLottoTickets() {
        return lottoTickets;
    }
}
