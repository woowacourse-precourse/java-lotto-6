package lotto;

import java.util.List;
import lotto.game.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoGame lottoGame = new LottoGame(InputView.getInputNumber());

        int numberOfGames = lottoGame.getNumberOfGames();
        OutputView.printBuyGames(numberOfGames);

        List<Lotto> lottoList = lottoGame.createLottoList(numberOfGames);
        OutputView.printLottoList(lottoList);

        int bonusNumber = InputView.getBonusNumber();
    }
}
