package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final LottoMachine lottoMachine;

    public LottoStore(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Lottos purchaseLottos(Money purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCount = purchaseAmount.getAmount() / 1000;

        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(lottoMachine.generateLotto());
        }

        return new Lottos(lottoList);
    }
}
