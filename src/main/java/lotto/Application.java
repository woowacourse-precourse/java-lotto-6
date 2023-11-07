package lotto;

import lotto.domain.game.GameController;
import lotto.domain.game.LottoGame;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.WinningNormalNumbers;
import lotto.domain.number.NumberGenerator;
import lotto.domain.game.Profit;
import lotto.domain.lotto.WinningNumbers;
import lotto.global.view.io.LottoInputProcessor;
import lotto.global.view.io.ProxyLottoInputProcessor;
import lotto.global.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {

            WinningNormalNumbers winningNormalNumbers = new WinningNormalNumbers();
            BonusNumber bonusNumber = new BonusNumber();

            WinningNumbers winningNumbers = new WinningNumbers(winningNormalNumbers, bonusNumber);

            LottoInputProcessor lottoInputProcessor = new LottoInputProcessor(winningNumbers);

            LottoGame lottoGame = new LottoGame();

            ProxyLottoInputProcessor proxyLottoInputProcessor = new ProxyLottoInputProcessor(lottoInputProcessor);
            GameController gameController = new GameController(proxyLottoInputProcessor , new NumberGenerator(), lottoGame);
            gameController.play();
        } catch (Exception e) {
            OutputView.printMessageLine(e.getMessage());
        }

    }
}
