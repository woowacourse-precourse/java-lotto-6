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

        // 당첨 번호, 보너스 번호 입력
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        // 당첨 번호를 생성합니다.
        Lotto winningLotto = new Lotto(winningNumbers);
        WinningLotto winning = new WinningLotto(winningLotto, bonusNumber);

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
