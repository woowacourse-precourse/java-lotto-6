package lotto.domain;

import java.util.List;

public class User {
    private int purchaseNumber;
    private List<Lotto> lottos;

    public User(int purchaseNumber, List<Lotto> lottos) {
        this.purchaseNumber = purchaseNumber;
        this.lottos = lottos;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }
    public List<Lotto> getLottos(){
        return lottos;
    }
}
