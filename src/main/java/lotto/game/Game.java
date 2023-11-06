package lotto.game;

import lotto.domain.Lotto;
import lotto.domain.Numbers;
import lotto.type.MainMessage;
import lotto.type.ResultMessage;

import java.util.List;

public class Game {

    public void play() {
        Machine machine = insertMoney();
        List<Lotto> lottos = getLottos(machine);
        List<Integer> winningNumber = getWinningNumber(machine);
        Numbers numbers = getBonusNumber(machine, winningNumber);
        int[] matchResult = getMatchResult(machine, lottos, numbers);
        getInvestmentResult(machine, matchResult);
    }

    private Machine insertMoney() {
        UserInterface.printOut(MainMessage.MONEY_TO_BUY.getMessage());
        Machine machine = new Machine(UserInterface.printIn());
        UserInterface.printOut(machine.getCount() + MainMessage.COUNT_OF_LOTTO.getMessage());
        return machine;
    }

    private List<Lotto> getLottos(Machine machine) {
        List<Lotto> lottos = machine.createLottoNumbers();
        for (int i = 0; i < machine.getCount(); i++) {
            UserInterface.printOut(lottos.get(i).getNumbers().toString());
        }
        return lottos;
    }

    private List<Integer> getWinningNumber(Machine machine) {
        UserInterface.printOut(MainMessage.TYPE_IN_WINNING_NUMBER.getMessage());
        return machine.createWinningNumber(UserInterface.printIn());
    }

    private Numbers getBonusNumber(Machine machine, List<Integer> winningNumber) {
        UserInterface.printOut(MainMessage.TYPE_IN_BONUS_NUMBER.getMessage());
        return machine.createBonusNumber(winningNumber, Integer.parseInt(UserInterface.printIn()));
    }

    private int[] getMatchResult(Machine machine, List<Lotto> lottos, Numbers numbers) {
        UserInterface.printOut(MainMessage.RESULT_OF_LOTTO.getMessage());
        int[] result = machine.createMatchResult(lottos, numbers);
        ResultMessage[] resultMessages = ResultMessage.values();
        for (int i = 0; i < result.length; i++) {
            UserInterface.printOut(resultMessages[i].getMessage() + result[i] + "개");
        }
        return result;
    }

    private void getInvestmentResult(Machine machine, int[] matchResult) {
        UserInterface.printOut(
                MainMessage.TOTAL_INVESTMENT_RESULT.getMessage()
                        + machine.calculateInvestmentResult(matchResult)
                        + MainMessage.RESULT_IS_PERCENTAGE.getMessage()
        );
    }

}
