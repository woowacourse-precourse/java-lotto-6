package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class Buyer {

    private static final int ROUND_CONSTANT_INT_TEN = 10;
    private static final double ROUND_CONSTANT_DOUBLE_TEN = 10.0;
    private static final double PERCENT = 100;

    private final int purchaseAmount;
    private List<Lotto> lottoNumbers = new ArrayList<>();


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

    public List<Lotto> getLottoNumbers(){
        return lottoNumbers;
    }


}
