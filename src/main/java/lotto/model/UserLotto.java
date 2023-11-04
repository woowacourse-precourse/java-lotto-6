package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserLotto{
    private final List<Lotto> myLotto;

    public UserLotto(List<Lotto> myLotto) {
        this.myLotto = myLotto;
    }

    public List<Lotto> getMyLotto() {
        return myLotto.stream()
                .map(o -> new Lotto(o.getNumbers()))
                .collect(Collectors.toList());
    }
}
