package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.Error.Domain.ZERO_PURCHASED_LOTTO;

public record PurchasedLotto(List<Lotto> lotto) {
    public PurchasedLotto {
        validate(lotto);
    }

    private void validate(List<Lotto> lotto) {
        if (lotto.isEmpty()) {
            throw new IllegalArgumentException(ZERO_PURCHASED_LOTTO.getMessage());
        }
    }

    @Override
    public List<Lotto> lotto() {
        return Collections.unmodifiableList(lotto);
    }
}
