package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {
    private final List<Lotto> myLotto;

    public UserLotto(List<Lotto> lotto) {
        myLotto = lotto;
    }

    public List<Lotto> getMyLotto() {
        return myLotto.stream()
                .map(o -> new Lotto(o.getLotto()))
                .collect(Collectors.toList());
    }

}
