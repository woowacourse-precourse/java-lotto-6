package lotto.model;

import java.util.List;

public class User {

    private final List<Lotto> issuanceLotto;

    public User(List<Lotto> issuanceLotto) {
        this.issuanceLotto = issuanceLotto;
    }

    public void addLotto(Lotto lotto) {
        this.issuanceLotto.add(lotto);
    }

    public List<Lotto> getIssuanceLotto() {
        return this.issuanceLotto;
    }
}
