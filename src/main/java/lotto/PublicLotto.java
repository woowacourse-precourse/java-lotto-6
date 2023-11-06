package lotto;

import java.util.List;

public class PublicLotto {
    private final List<Lotto> lotto;
    public PublicLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
