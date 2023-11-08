package lotto.dto;

import lotto.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsDto {
    private List<LottoTicketDto> lottoTickets;

    public LottoTicketsDto(LottoTickets lottoTickets) {
        List<LottoTicketDto> lottoTicketDtos = lottoTickets.getLottoTickets().stream()
                .map(LottoTicketDto::new)
                .collect(Collectors.toList());
        this.lottoTickets = lottoTicketDtos;
    }

    public List<LottoTicketDto> getLottoTickets() {
        return lottoTickets;
    }

    public int getTotalCount() {
        return lottoTickets.size();
    }

}
