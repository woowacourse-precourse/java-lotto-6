package lotto.domain;

import lotto.validator.MainValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> lotto;
    private final MainValidator mainValidator = new MainValidator();

    public Lotto(List<Integer> lotto, Lottos lottos) {
        mainValidator.validateLotto(lotto);
        this.lotto = lotto;
        lottos.addLotto(this);
    }

    public List<Integer> getNumbers() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}