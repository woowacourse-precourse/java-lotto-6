package lotto.dto;

import java.util.List;
import lotto.model.Lottos;

public record LottosResult(int lottosCount, List<LottoResult> lottoResults) {

    public static LottosResult from(Lottos lottos) {
        return new LottosResult(lottos.getLottosCount(),
                lottos.getLottos()
                        .stream()
                        .map(LottoResult::from)
                        .toList());
    }
}
