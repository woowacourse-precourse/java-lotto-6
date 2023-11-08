package lotto;

import lotto.console.InputConsole;
import lotto.console.OutputConsole;
import lotto.model.Lotto;
import lotto.model.Capital;
import lotto.model.Player;
import lotto.model.WinningDetails;
import lotto.model.LottoMachine;

public class LottoGame {

    void run() {
        Player player = initPlayer();
        OutputConsole.printPlayerPurchases(player);

        LottoMachine lottoMachine = initLottoMachine();

        WinningDetails winningDetails = player.getWinningDetails(lottoMachine);
        OutputConsole.printWinningDetails(winningDetails);
    }

    private Player initPlayer() {
        Capital capital = InputConsole.getCapital();
        return new Player(capital);
    }

    private LottoMachine initLottoMachine() {
        Lotto winningNumbers = InputConsole.getWinningNumbers();
        int bonusNumber = InputConsole.getBonusNumber(winningNumbers);

        return new LottoMachine(winningNumbers, bonusNumber);
    }
}
