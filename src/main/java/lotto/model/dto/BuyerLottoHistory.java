package lotto.model.dto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public record BuyerLottoHistory(int lottoCount, List<Lotto> lottos) {
    public static BuyerLottoHistory of(Lottos buyerLottos) {
        List<Lotto> lottos = buyerLottos.getLottos();
        return new BuyerLottoHistory(lottos.size(), lottos);
    }
}