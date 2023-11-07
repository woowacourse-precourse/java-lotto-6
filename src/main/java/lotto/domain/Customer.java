package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Customer {
    private List<Lotto> lottos;

    public void setLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void insertMoney(final LottoStore lottoStore, final long money) {
        lottoStore.getMoney(money);
    }

    public void checkResult(LottoChecker lottoChecker) {
        lottoChecker.checkLottos(this.lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }
}
