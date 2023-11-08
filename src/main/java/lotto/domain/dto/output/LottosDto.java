package lotto.domain.dto.output;

import lotto.domain.Lottos;

import java.util.List;

public record LottosDto(List<LottoDto> lottoNumbers, int quantity) {

    public static LottosDto createLottosDto(Lottos lottos) {
        List<LottoDto> lottoNumbers = lottos.getLottoTickets()
                .stream()
                .map(LottoDto::createLottoDto)
                .toList();
        return new LottosDto(lottoNumbers, lottoNumbers.size());
    }
}
