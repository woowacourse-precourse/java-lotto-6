package lotto;

import java.util.List;
import java.util.Map;
import lotto.game.LottoGame;
import lotto.game.Result;
import lotto.game.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoGame lottoGame = new LottoGame(InputView.getInputNumber());

        int numberOfGames = lottoGame.getNumberOfGames();
        OutputView.printBuyGames(numberOfGames);

        List<Lotto> lottoList = lottoGame.createLottoList(numberOfGames);
        OutputView.printLottoList(lottoList);

        List<Integer> winningNumber = InputView.winningNumber();
        int bonusNumber = InputView.getBonusNumber();

        WinningLotto winningLotto = lottoGame.createdWinningLotto(winningNumber, bonusNumber);
        Map<Result, Integer> resultCount = lottoGame.getResultCount(lottoList, winningLotto);

        OutputView.printResult(numberOfGames, resultCount);
    }
}
