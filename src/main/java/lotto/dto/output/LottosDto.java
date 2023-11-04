package lotto.dto.output;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public record LottosDto(List<LottoDto> lottos) {
    public static LottosDto from(Lottos lottoTickets) {
        List<LottoDto> lottos = getLottoTickets(lottoTickets);
        return new LottosDto(lottos);
    }

    private static List<LottoDto> getLottoTickets(Lottos lottoTickets) {
        List<LottoDto> lottos = new ArrayList<>();
        // ref. 스트림 사용하기
        for (Lotto lottoTicket : lottoTickets.getLottos()) {
            LottoDto lottoDto = LottoDto.toLottoDto(lottoTicket);
            lottos.add(lottoDto);
        }
        return lottos;
    }
}
