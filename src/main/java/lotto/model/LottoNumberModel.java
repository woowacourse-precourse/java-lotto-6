package lotto.model;

import lotto.domain.Lotto;

import java.util.List;

public class LottoNumberModel {
    private List<Lotto> lotto;
    private int lottoQuantity;

    public LottoNumberModel(List<Lotto> lotto) {
        this.lotto = lotto;
        this.lottoQuantity = lotto.size();
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }

    public void lottoNumberDisplay(){
        for (int quantity = 1 ; quantity <= lottoQuantity ; quantity++){
            lotto.get(quantity-1).lottoNumberDisplay();
        }
    }
}
