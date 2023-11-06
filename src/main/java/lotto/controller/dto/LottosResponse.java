package lotto.controller.dto;

import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottosResponse {

    private final List<LottoResponse> lottos;

    public LottosResponse(final List<LottoResponse> lottos) {
        this.lottos = lottos;
    }

    public static LottosResponse from(final List<Lotto> lottos) {
        return new LottosResponse(convertFrom(lottos));
    }

    private static List<LottoResponse> convertFrom(final List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> LottoResponse.from(lotto.getNumbers()))
                .toList();
    }

    public List<LottoResponse> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
