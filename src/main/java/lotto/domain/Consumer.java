package lotto.domain;


import java.util.List;
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
        LottoPrice.THOUSAND_WON.validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void setLottos(List<Lotto> lottos) {
        lottosCountValidate(lottos);
        this.lottos = lottos;
    }

    private void lottosCountValidate(List<Lotto> lottos){
        if(LottoPrice.THOUSAND_WON.calcLottoCount(purchaseAmount) != lottos.size()){
            ExceptionMessage.LOTTOS_COUNT_MISMATCH_COUNT.throwException();
        }
    }
}
