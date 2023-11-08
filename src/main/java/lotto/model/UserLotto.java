package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {
    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> lotto) {
        userLotto = lotto;
    }

    public List<Lotto> getUserLotto() {
        return userLotto.stream()
                .map(o -> new Lotto(o.getLotto()))
                .collect(Collectors.toList());
    }

}
