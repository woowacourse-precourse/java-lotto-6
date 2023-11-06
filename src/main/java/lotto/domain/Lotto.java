package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        LottoValidator.go(lotto);
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
