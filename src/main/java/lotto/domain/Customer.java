package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class Customer {
    private final int money;
    private final List<Lotto> issuedLottos;

    public Customer(int money) {
        this.money = money;
        this.issuedLottos = new ArrayList<>();
    }

    public void buyLotto(final Lotto lotto) {
        this.issuedLottos.add(lotto);
    }

    public final List<Lotto> getIssuedLottos() {
        return this.issuedLottos;
    }

    public final int getMoney() {
        return this.money;
    }
}
