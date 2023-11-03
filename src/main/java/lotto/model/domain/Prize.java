package lotto.model.domain;

public class Prize {
    private final Lotto lotto;

    private Prize(Lotto lotto) {
        this.lotto = lotto;
    }

    public static Prize of(Lotto lotto) {
        return new Prize(lotto);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
