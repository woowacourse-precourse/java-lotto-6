package lotto.domain;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> bundle;

    public LottoBundle(List<Lotto> lottos) {
        this.bundle = lottos;
    }

    public List<Lotto> getBundle() {
        return List.copyOf(bundle);
    }

    /**
     * 묶음으로 부터 로또 구매액을 계산
     *
     * @return 로또 구매액
     */
    public int showInvestment() {
        return bundle.size() * 1000;
    }
}
