package lotto;

import java.util.List;

public class Application {
    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);

        ResultView.printPurchasedLottos(lottos);

        Lotto winningLotto = null;
        WinningLotto winning = null;

        while (winningLotto == null) {
            try {
                List<Integer> winningNumbers = InputView.getWinningNumbers();
                winningLotto = new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (winning == null) {
            try {
                int bonusNumber = InputView.getBonusNumber();
                winning = new WinningLotto(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            LottoRank rank = winning.checkRank(lotto);
            result.record(rank);
        }

        ResultView.printResult(result, purchaseAmount);
    }
    public static void main(String[] args) {
        new Application().run();
    }
}
