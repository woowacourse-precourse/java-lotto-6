package lotto;

import java.util.List;

public class Application {
    public void run() {
        // 가정된 사용자 입력 처리
        int purchaseAmount = InputView.getPurchaseAmount();

        // 로또 기계를 생성하고 로또를 구매합니다.
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);

        // 구매한 로또 결과를 출력합니다.
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

        // 로또 결과를 계산합니다.
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            LottoRank rank = winning.checkRank(lotto);
            result.record(rank);
        }

        // 결과를 출력합니다.
        ResultView.printResult(result, purchaseAmount);
    }
    public static void main(String[] args) {
        new Application().run();
    }
}
