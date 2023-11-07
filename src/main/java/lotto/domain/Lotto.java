package lotto.domain;

import java.util.Comparator;
import java.util.List;


public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validate(lotto);
        sortLotto(lotto);
        this.lotto = lotto;
    }

    private void validate(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sortLotto(List<Integer> lotto) {
        lotto.sort(Comparator.naturalOrder());
    }

    public String getLotto() {
        return toString();
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
