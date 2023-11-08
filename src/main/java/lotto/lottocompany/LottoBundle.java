package lotto.lottocompany;

import java.util.List;

public class LottoBundle {

    private final List<Lotto> bundle;

    private LottoBundle(List<Lotto> bundle) {
        this.bundle = bundle;
    }

    public List<Lotto> getBundle() {
        return List.copyOf(bundle);
    }

    public static LottoBundle create(List<Lotto> bundle) {
        return new LottoBundle(bundle);
    }

    public void addLotto(List<Lotto> bundles) {
        bundle.addAll(bundles);
    }
}
