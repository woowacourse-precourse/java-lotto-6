package lotto.constants;

import lotto.domain.Lotto;

public enum EmptyLotto {
    NULL(null);

    private final Lotto lotto;

    EmptyLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto get() {
        return lotto;
    }
}
