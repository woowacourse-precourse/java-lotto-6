package lotto.domain;

import static lotto.validator.LottoNumbersValidator.validateLotto;

import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validateLotto(lotto);
        this.lotto = lotto;
    }

    public List<Integer> getLottoNumbers() {
        return lotto;
    }
}
