package lotto.model.dto;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.List;

public record BuyerLottoHistory(int lottoCount, List<Lotto> lottos) {
    public static BuyerLottoHistory of(Lottos buyerLottos) {
        List<Lotto> lottos = buyerLottos.getLottos();
        return new BuyerLottoHistory(lottos.size(), lottos);
    }
}