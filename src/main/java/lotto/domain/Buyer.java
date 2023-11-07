package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private final Amount amount;
    private final List<Lotto> lottos = new ArrayList<>();

    public Buyer(String amount) {
        this.amount = new Amount(amount);
    }

    public int getAmount() {
        return this.amount.getAmount();
    }

    public void setLottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }


}
