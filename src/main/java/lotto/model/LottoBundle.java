package lotto.model;

import lotto.exception.business.LottoException;

import java.util.Collections;
import java.util.List;

import static lotto.view.message.ValidationErrorMessage.LOTTO_BUNDLE_EMPTY;
import static lotto.view.message.ValidationErrorMessage.LOTTO_BUNDLE_NULL;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        validateNull(lottoBundle);
        validateNotEmpty(lottoBundle);
        this.lottoBundle = lottoBundle;
    }

    private void validateNull(List<Lotto> lottoBundle) {
        if (lottoBundle == null) {
            throw new NullPointerException(LOTTO_BUNDLE_NULL.getMessage());
        }
    }

    private void validateNotEmpty(List<Lotto> lottoBundle) {
        if (lottoBundle.isEmpty()) {
            throw new LottoException(LOTTO_BUNDLE_EMPTY.getMessage());
        }
    }

    public List<Lotto> getLottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }
}
