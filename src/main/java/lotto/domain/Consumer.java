package lotto.domain;


import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrice;
import lotto.exception.ExceptionMessage;

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
        amountValidate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    void amountValidate(int purchaseAmount){
        int price = LottoPrice.THOUSAND_WON.getPrice();
        if(purchaseAmount % price != 0){
            ExceptionMessage.PURCHASE_AMOUNT_NOT_DIVIDED.throwException();
        }
    }
}
