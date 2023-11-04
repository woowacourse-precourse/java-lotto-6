package lotto.model.collections;

import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        validate(lottoBundle);
        this.lottoBundle = lottoBundle;
    }

    private void validate(List<Lotto> numbers) {
        //검증 로직
    }

    public List<Lotto> getLottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }
}
