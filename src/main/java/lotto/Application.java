package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자로부터 구입 금액을 입력 받습니다.
        int purchaseAmount = InputView.inputPurchaseAmount();

        // 2. 로또 게임을 생성하고 로또 티켓을 구입합니다.
        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottoTickets = lottoGame.purchaseLottoTickets(purchaseAmount / Lotto.PRICE);

        // 3. 구매한 로또 티켓을 출력합니다.
        OutputView.printLottoTickets(lottoTickets);

        // 4. 당첨 번호를 추첨합니다.
        Lotto winningLotto = lottoGame.drawWinningLotto();

        // 5. 로또 게임을 진행하고 결과를 계산합니다.
        lottoGame.play(lottoTickets, winningLotto);

        // 6. 당첨 결과를 출력합니다.
        Map<Integer, Integer> winningResult = lottoGame.getWinningResult();
        OutputView.printWinningResult(winningResult);
    }
}
