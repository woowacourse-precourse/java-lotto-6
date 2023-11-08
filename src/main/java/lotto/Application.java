package lotto;

import java.util.List;

public class Application {

    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final ResultView resultView;

    public Application() {
        this.lottoMachine = new LottoMachine();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        int purchaseAmount = inputView.getPurchaseAmount();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);
        resultView.printPurchasedLottos(lottos);

        Lotto winningLotto = new Lotto(inputView.getWinningNumbers());
        WinningLotto winning = new WinningLotto(winningLotto, inputView.getBonusNumber());

        LottoResult result = calculateResult(lottos, winning);
        resultView.printResult(result, purchaseAmount);
    }

    private LottoResult calculateResult(List<Lotto> lottos, WinningLotto winning) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            LottoRank rank = winning.checkRank(lotto);
            result.record(rank);
        }
        return result;
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
