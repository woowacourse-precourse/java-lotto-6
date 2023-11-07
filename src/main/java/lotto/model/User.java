package lotto.model;

import java.util.HashMap;

public class User {
    private int money;
    private HashMap<Lotto, Rank> lottos;

    public User(int money, HashMap<Lotto, Rank> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public void setLottoResult(Lotto lotto, Rank rank){
        this.lottos.put(lotto, rank);
    }

    public HashMap<Lotto, Rank> getLottos() {
        return lottos;
    }

    public int getNumber(){
        return money / Constant.LOTTO_PRICE;
    }
}
