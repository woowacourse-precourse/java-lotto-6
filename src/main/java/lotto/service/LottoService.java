package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public LottoBundle buyLottoBundle(LottoMoney money) {
        int amount = money.getLottoAmount();
        List<Lotto> bundle = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = LottoMachine.buyLotto();
            bundle.add(lotto);
        }
        return new LottoBundle(bundle, amount);
    }
}
