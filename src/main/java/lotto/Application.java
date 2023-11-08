import lotto.Lotto;
import lotto.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 사용자에게 구입 금액 입력 받기
        int purchaseAmount = InputView.getPurchaseAmount();

        // 구입 금액에 따라 로또를 구매
        List<Lotto> lottos = LottoStore.buyLottos(purchaseAmount);

        // 사용자에게 당첨 번호와 보너스 번호 입력 받기
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        // 로또 결과 계산
        Result result = LottoResult.calculateResult(lottos, winningNumbers, bonusNumber);

        // 결과 출력
        OutputView.printLottos(lottos);
        OutputView.printResult(result);
    }
}
