package lotto.domain;

import java.util.List;

public class AutomaticLotto extends Lotto {

    public AutomaticLotto() {
        super();
    }

    public static AutomaticLotto from() {
        return new AutomaticLotto();
    }

    public List<Integer> getAutomaticLottoNumbers() {
        return this.getNumbers();
    }
}
