package lotto.model;

import java.util.List;

public class UserLotto {
    private final List<Integer> lotto;

    public UserLotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
