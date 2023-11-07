package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Numbers;
import lotto.game.Machine;
import lotto.game.UserOutput;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserOutput.inputMoney();
        String money = Console.readLine();
        Machine machine = new Machine(money);
        UserOutput.getLottoCount(String.valueOf(machine.getCount()));
        List<Lotto> lottos = machine.createLottoNumbers();
        UserOutput.showLottos(machine, lottos);
        UserOutput.inputWinningNumber();
        String WinningNumberInput = Console.readLine();
        List<Integer> winningNumber = machine.createWinningNumber(WinningNumberInput);
        UserOutput.inputBonusNumber();
        int bonusNumberInput = Integer.parseInt(Console.readLine());
        machine.createBonusNumber(winningNumber, bonusNumberInput);
        Numbers numbers = new Numbers(winningNumber, bonusNumberInput);
        UserOutput.getWinningResult();
        int[] matchResult = machine.createMatchResult(lottos, numbers);
        UserOutput.getMatch3(String.valueOf(matchResult[0]));
        UserOutput.getMatch4(String.valueOf(matchResult[1]));
        UserOutput.getMatch5(String.valueOf(matchResult[2]));
        UserOutput.getMatch5A(String.valueOf(matchResult[3]));
        UserOutput.getMatch6(String.valueOf(matchResult[4]));
        double investmentRate = machine.calculateInvestmentResult(matchResult);
        UserOutput.getInvestmentResult(String.valueOf(investmentRate));
    }
}
