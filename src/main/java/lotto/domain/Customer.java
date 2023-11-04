package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private int money = 0;

    public void purchaseLotto(LottoMachine machine){
        purchasedLottos.addAll(machine.purchaseLottos(money));
        money = 0;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
