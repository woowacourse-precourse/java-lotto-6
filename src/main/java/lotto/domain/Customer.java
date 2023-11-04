package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private int money = 0;

    public void purchaseLotto(LottoMachine machine) {
        purchasedLottos.addAll(machine.purchaseLottos(money));
        money = 0;
    }

    public void printPurchasedLottos() {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto);
        }
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
