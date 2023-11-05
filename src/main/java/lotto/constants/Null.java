package lotto.constants;

import lotto.domain.Lotto;

public enum Null {
    NULL(null);

    private final Lotto lotto;

    Null(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto get() {
        return lotto;
    }
}
