package lotto.Controller;

import static lotto.View.InputView.printInsertBonusNumber;
import static lotto.View.InputView.printInsertLottoNumbers;
import static lotto.View.InputView.printInsertMoney;

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
    InputView inputView;
    OutputView outputView;

    public GameController() {
        gameRule = new GameRule();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void runGame() {
        Cpu cpu = getUserValidMoney();
        int tickets = cpu.getTickets();
        int money = tickets * IntConstants.UNIT_BILL.getValue();

        printTicketsAndLotto(cpu, tickets);
        Lotto playerLottoNumbers = getUserValidLottoNumber();
        Player playerLotto = getUserValidBonusNumber(playerLottoNumbers);

        List<Integer> gameResult = gameRule.calculateResult(cpu, playerLotto);
        String totalProfit = gameRule.calculateProfit(money, gameResult);
        printAllResult(gameResult, totalProfit);
    }

    private Cpu getUserValidMoney() {
        while (true) {
            try {
                printInsertMoney();
                int money = inputView.insertMoney();
                return new Cpu(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getUserValidLottoNumber() {
        while (true) {
            try {
                printInsertLottoNumbers();
                List<Integer> playerLottoNumbers = inputView.insertLottoNumbers();
                return new Lotto(playerLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Player getUserValidBonusNumber(Lotto playerLotto) {
        while (true) {
            try {
                printInsertBonusNumber();
                int playerBonusNumber = inputView.insertBonusNumber();
                return new Player(playerLotto, playerBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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

