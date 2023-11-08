package lotto.model;

import java.util.List;

public class UserLotto {
    private final List<Lotto> userLotto;

    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

}
