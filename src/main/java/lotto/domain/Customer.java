package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int money;
    private final List<Lotto> issuedLottos;

    public Customer(int money) {
        this.money = money;
        this.issuedLottos = new ArrayList<>();
    }

    public void buyLotto(Lotto lotto) {
        this.issuedLottos.add(lotto);
    }

    public final List<Lotto> getIssuedLottos() {
        return this.issuedLottos;
    }

    public final int getMoney() {
        return this.money;
    }
}
