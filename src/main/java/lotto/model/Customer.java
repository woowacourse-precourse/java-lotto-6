package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {

    private int purchaseMoney;
    private ArrayList<Lotto> purchaseLotteries = new ArrayList<>();
    private HashMap<Ranking,Integer> lottoResult = new HashMap<>();

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

    public HashMap<Ranking,Integer> getLottoResult(){
        return lottoResult;
    }

}
