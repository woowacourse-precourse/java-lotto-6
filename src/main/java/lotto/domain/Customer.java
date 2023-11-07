package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Customer {
    private List<Lotto> lottos;

    public void setLotto(List<Lotto> lottoPapers) {
        this.lottos = lottoPapers;
    }

    public void insertMoney(final LottoStore lottoStore, final long money) {
        lottoStore.getMoney(money);
    }

    public void checkWinningNumber(LottoChecker lottoChecker) {
        lottoChecker.insertLottos(this.lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }
}
