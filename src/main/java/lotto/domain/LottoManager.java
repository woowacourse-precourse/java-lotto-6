package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoManager {
    private static final LottoManager lottoManager = new LottoManager();
    private static final int LOTTO_PRICE = 1000;

    private LottoManager() {
    }

    public LottoManager getInstance() {
        return lottoManager;
    }

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(Lotto.generate());
        }

        return lottos;
    }

}
