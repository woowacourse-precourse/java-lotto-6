package lotto.Controller;

import java.util.List;
import lotto.Constants.IntConstants;
import lotto.Model.Cpu;
import lotto.Model.GameRule;
import lotto.Model.Lotto;
import lotto.Model.Player;
import lotto.View.InputView;
import lotto.View.OutputView;

public class GameController {
    GameRule gameRule;
    UserInputHandler userInputHandler;
    OutputView outputView;

    public GameController() {
        gameRule = new GameRule();
        userInputHandler = new UserInputHandler(new InputView());
        outputView = new OutputView();
    }

    public void runGame() {
        Cpu cpu = userInputHandler.getUserValidMoney();
        int tickets = cpu.getTickets();
        int money = tickets * IntConstants.UNIT_BILL.getValue();

        printTicketsAndLotto(cpu, tickets);
        Lotto playerLottoNumbers = userInputHandler.getUserValidLottoNumber();
        Player playerLotto = userInputHandler.getUserValidBonusNumber(playerLottoNumbers);

        List<Integer> gameResult = gameRule.calculateResult(cpu, playerLotto);
        String totalProfit = gameRule.calculateProfit(money, gameResult);
        printAllResult(gameResult, totalProfit);
    }

    private void printAllResult(List<Integer> gameResult, String totalProfit) {
        outputView.printResultMessage();
        outputView.printContourLine();
        outputView.printLottoResult(gameResult);
        outputView.printTotalProfit(totalProfit);
    }

    private void printTicketsAndLotto(Cpu cpu, int tickets) {
        outputView.printBuyTickets(tickets);
        outputView.printLottoNumbers(cpu, tickets);
    }
}

