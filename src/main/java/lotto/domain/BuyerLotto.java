package lotto.domain;

import java.util.List;

public class BuyerLotto {

    private final List<Lotto> buyerLotto;

    public BuyerLotto(List<Lotto> buyerLotto) {
        this.buyerLotto = buyerLotto;
    }

    public List<Lotto> getBuyerLotto() {
        return buyerLotto;
    }
}
