package lotto.model;

import lotto.exception.model.LottoException;

import java.util.Collections;
import java.util.List;

import static lotto.view.message.ValidationErrorMessage.LOTTO_BUNDLE_EMPTY;
import static lotto.view.message.ValidationErrorMessage.LOTTO_BUNDLE_NULL;

public record LottoBundle(List<Lotto> lottoBundle) {
    @Override
    public List<Lotto> lottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }

    public LottoBundle {
        validateNull(lottoBundle);
        validateNotEmpty(lottoBundle);
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
}
