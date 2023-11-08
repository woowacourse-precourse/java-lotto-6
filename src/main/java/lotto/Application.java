package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printEnterPurchaseAmount();
        int purchaseAmount = inputView.getPurchaseAmount();
        List<Lotto> lottos = new LottoMachine().issueLottos(purchaseAmount);
        outputView.printLottos(lottos);

        outputView.printEnterWinningNumber();
        List<Integer> winningNumbers = inputView.getWinningNumbers();

        outputView.printEnterBonusNumber();
        int bonusNumber = inputView.getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Game lottoGame = new Game(lottos, winningLotto);
        Map<Rank, Integer> result = lottoGame.run();
        double earningRate = lottoGame.getEarningRate(result, purchaseAmount);

        outputView.printResult(result, earningRate);
    }


}
