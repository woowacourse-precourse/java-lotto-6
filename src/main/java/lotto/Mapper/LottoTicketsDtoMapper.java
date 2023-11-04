package lotto.Mapper;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoTicketsDto;
import lotto.model.LottoTickets;

public class LottoTicketsDtoMapper {
    public static LottoTicketsDto from(LottoTickets lottoTickets) {
        List<LottoDto> lottoTicketsDto = lottoTickets.getLottoTickets()
                .stream()
                .map(LottoDtoMapper::from)
                .toList();
        return new LottoTicketsDto(lottoTicketsDto);
    }
}
