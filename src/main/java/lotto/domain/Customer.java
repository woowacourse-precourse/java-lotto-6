package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int wallet;
    private List<Lotto> customerLotto;
    private int hasTicket;

    public Customer(int coin) {
        validateCoin(coin);
        this.wallet = coin;
        this.customerLotto = new ArrayList<>();
        this.hasTicket = 0;
    }

    public void addCustomerLotto(Lotto newLotto) {
        this.customerLotto.add(newLotto);
        this.hasTicket++;
    }

    public void pay(int price) {
        this.wallet -= price;
    }

    private void validateCoin(int coin) {
        if (coin % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000단위만 허용합니다.");
        }
    }

    public int getWallet() {
        return this.wallet;
    }

    public Lotto getCustomerLotto(int i) {
        return this.customerLotto.get(i);
    }

    public int getHasTicket() {
        return this.hasTicket;
    }
}
