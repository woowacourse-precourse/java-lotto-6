package lotto.model;

import java.util.ArrayList;

public class Customer {

    private int purchaseMoney;
    private ArrayList<Lotto> purchaseLotteries = new ArrayList<>();

    public Customer(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public int getPurchaseMoney() {
        return this.purchaseMoney;
    }

    public void buyLotto(Lotto lotto) {
        purchaseLotteries.add(lotto);
    }

    public ArrayList<Lotto> getPurchaseLotteries() {
        return purchaseLotteries;
    }

}
