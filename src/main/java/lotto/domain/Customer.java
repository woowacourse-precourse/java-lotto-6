package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int wallet;
    private List<Lotto> customerLotto;
    private int hasTicket;

    public Customer(int coin) {
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
