package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.game.Machine;
import lotto.game.UserConsole;

import java.util.List;
import java.util.Map;

import static lotto.game.UserConsole.*;

public class Application {
    public static void main(String[] args) {

        long money = getMoney();
        Machine machine = new Machine(money);
        showPurchasedLottoCount(machine);

        List<Lotto> lottos = machine.createLottos();

        WinningNumber winningNumber = new WinningNumber(inputFirstWinningNumber(),
                inputBonusNumber());

        Map<Double, Integer> matchResult = machine.createMatchResult(lottos, winningNumber);
        UserConsole.showWinningResult(matchResult);

        double investmentRate = machine.calculateInvestmentResult(matchResult);
        UserConsole.getInvestmentResult(investmentRate);
    }
}
