package lotto.domain;

import java.util.List;
import lotto.view.OutputView;

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

    public void printLotto() {
        OutputView.printNumberOfLottoTickets(lottoNumbers.size());
        OutputView.printLottoTickets(lottoNumbers);
    }
}
