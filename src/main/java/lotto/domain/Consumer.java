package lotto.domain;


import java.util.List;

public class Consumer {
    private int purchaseAmount;
    private List<Lotto> lottos;

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        LottoPrice.THOUSAND_WON.validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
