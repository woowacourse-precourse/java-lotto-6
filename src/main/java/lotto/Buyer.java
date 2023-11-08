package lotto;


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

    public void buyLotto(int price) {
        checkPriceValidation(price);
        this.price = price;
        this.lottos = lottoMachine.inputPurchasePrice(this.price);
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

    public void aggregateLotto() {
        lottoResultChecker.checkLotto(this.lottos, this.winningLotto);
        lottoResultChecker.printTotalPrize();
        lottoResultChecker.printProfit(this.price);
    }
}
