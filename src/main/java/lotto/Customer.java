package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int money;
    private List<Lotto> issuedLottos;

    public Customer(int money) {
        this.money = money;
        issuedLottos = new ArrayList<>();
    }

    public void buyLotto(Lotto lotto) {
        issuedLottos.add(lotto);
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }
}
