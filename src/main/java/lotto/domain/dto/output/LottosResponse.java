package lotto.domain.dto.output;

import lotto.domain.Lottos;

import java.util.List;

public record LottosResponse(List<LottoResponse> lottoNumbers, int quantity) {

    public static LottosResponse createLottosResponse(Lottos lottos) {
        List<LottoResponse> lottoNumbers = lottos.getLottoTickets()
                .stream()
                .map(LottoResponse::createLottoResponse)
                .toList();
        return new LottosResponse(lottoNumbers, lottoNumbers.size());
    }
}
