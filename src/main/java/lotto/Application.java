package lotto;

import java.util.List;

public class Application {
    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(purchaseAmount);
        printPurchasedLottos(lottos);
        WinningLotto winning = getWinningLotto();
        calculateAndPrintResult(lottos, winning, purchaseAmount);
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.purchaseLottos(purchaseAmount);
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        ResultView.printPurchasedLottos(lottos);
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = getWinningNumbers();
        return getBonusNumber(winningLotto);
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = InputView.getWinningNumbers();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                int bonusNumber = InputView.getBonusNumber();
                return new WinningLotto(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calculateAndPrintResult(List<Lotto> lottos, WinningLotto winning, int purchaseAmount) {
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
