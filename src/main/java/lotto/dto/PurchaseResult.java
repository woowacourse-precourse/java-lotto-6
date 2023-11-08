package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public class PurchaseResult {

    private int quantity;
    private List<Lotto> lottos;

    public PurchaseResult(int quantity, List<Lotto> lottos) {
        this.quantity = quantity;
        this.lottos = lottos;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
