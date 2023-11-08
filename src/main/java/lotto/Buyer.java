package lotto;


import java.util.HashMap;
import java.util.List;

public class Buyer {
    private final LottoMachine lottoMachine;
    private final LottoResultChecker lottoResultChecker;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private int price;

    public Buyer(LottoMachine lottoMachine, LottoResultChecker lottoResultChecker) {
        this.lottoMachine = lottoMachine;
        this.lottoResultChecker = lottoResultChecker;
    }

    public List<Lotto> buyLotto(int price) {
        checkPriceValidation(price);
        this.price = price;
        this.lottos = lottoMachine.inputPurchasePrice(this.price);
        return this.lottos;
    }

    private void checkPriceValidation(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(CustomErrorMessage.PRICE_VALID);
        }
    }

    public void drawWinningNumbersAndBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        this.winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    public HashMap<LottoRank, Integer> aggregateLotto() {
        lottoResultChecker.checkLotto(this.lottos, this.winningLotto);
        return lottoResultChecker.getLottoResult();
    }

    public double getProfitRatio() {
        return lottoResultChecker.getProfitRatio(this.price);
    }
}
