package lotto.service;

import lotto.Constant.PurchaseAmount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> buyLottos(int purchaseAmount) {
        int lottoQuantity = getLottoQuantity(purchaseAmount);
        return getLottos(lottoQuantity);
    }

    private static int getLottoQuantity(int purchaseAmount) {
        return purchaseAmount / PurchaseAmount.UNIT.getAmount();
    }

    private List<Lotto> getLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        getLotto(lottoQuantity, lottos);
        return lottos;
    }

    private void getLotto(int lottoQuantity, List<Lotto> lottos) {
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
    }
}
