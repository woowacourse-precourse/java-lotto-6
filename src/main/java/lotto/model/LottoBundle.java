package lotto.model;

import lotto.exception.business.LottoException;
import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        validateNull(lottoBundle);
        validateNotEmpty(lottoBundle);
        this.lottoBundle = lottoBundle;
    }

    private void validateNull(List<Lotto> lottoBundle) {
        if (lottoBundle == null) {
            throw new NullPointerException("로또 묶음이 null 값 입니다.");
        }
    }

    private void validateNotEmpty(List<Lotto> lottoBundle) {
        if (lottoBundle.isEmpty()) {
            throw new LottoException("로또 묶음이 비어 있습니다.");
        }
    }

    public List<Lotto> getLottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }
}
