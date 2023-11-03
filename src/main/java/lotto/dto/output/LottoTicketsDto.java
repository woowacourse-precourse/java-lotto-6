package lotto.dto.output;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;

public record LottoTicketsDto(List<LottoDto> lottoTickets) {
    public static LottoTicketsDto from(LottoTickets lottoTickets) {
        List<LottoDto> lottos = getLottoTickets(lottoTickets);
        return new LottoTicketsDto(lottos);
    }

    private static List<LottoDto> getLottoTickets(LottoTickets lottoTickets) {
        List<LottoDto> lottos = new ArrayList<>();
        // ref. 스트림 사용하기
        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            LottoDto lottoDto = LottoDto.toLottoDto(lottoTicket);
            lottos.add(lottoDto);
        }
        return lottos;
    }
}
