package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Customer {
    private List<Lotto> lottos;

    public void setLottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void insertMoney(final LottoStore lottoStore, final long money) {
        lottoStore.insertMoney(money);
    }

    public void checkResult(final LottoChecker lottoChecker) {
        lottoChecker.checkLottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
