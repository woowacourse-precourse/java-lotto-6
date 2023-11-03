package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.Error.Domain.EMPTY_LOTTO;

public record PurchasedLotto(List<Lotto> lotto) {
    public PurchasedLotto {
        validate(lotto);
    }

    private void validate(List<Lotto> lotto) {
        if (lotto.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LOTTO.getText());
        }
    }

    @Override
    public List<Lotto> lotto() {
        return Collections.unmodifiableList(lotto);
    }
}
