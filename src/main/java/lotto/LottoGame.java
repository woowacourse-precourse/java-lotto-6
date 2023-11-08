package lotto;

import lotto.console.InputConsole;
import lotto.console.OutputConsole;
import lotto.model.Lotto;
import lotto.model.Capital;
import lotto.model.Player;
import lotto.model.WinningDetails;
import lotto.utils.LottoMachine;

public class LottoGame {

    void run() {
        Capital capital = InputConsole.getCapital();
        Player player = new Player(capital);

        OutputConsole.printPlayerPurchases(player);

        Lotto winningNumbers = InputConsole.getWinningNumbers();
        int bonusNumber = InputConsole.getBonusNumber();

        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);
        WinningDetails winningDetails = player.getWinningDetails(lottoMachine);

        OutputConsole.printWinningDetails(winningDetails);
    }


}
