package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class Buyer {

    private int purchaseAmount;
    private List<Lotto> lottoNumbers;

    public Buyer(int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
        buyLotto();
    }

    public void buyLotto(){
        lottoNumbers = LottoMachine.generate(purchaseAmount);
    }
}
