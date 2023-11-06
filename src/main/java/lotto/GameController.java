package lotto;

import static lotto.InputController.getValidInput;
import static lotto.InputView.printBonusNumber;
import static lotto.InputView.printInsertLottoNumbers;
import static lotto.InputView.printInsertMoney;

import java.util.List;
import lotto.Constants.IntConstants;

public class GameController {

    GameRule gameRule = new GameRule();


    public void runGame() {
        printInsertMoney();
        Cpu cpu = insertMoneyControl();
        int tickets = cpu.getTickets();
        int money = tickets * IntConstants.UNIT_BILL.getValue();
        OutputView.printBuyTickets(tickets);
        OutputView.printLottoNumbers(cpu, tickets);

        printInsertLottoNumbers();
        Lotto playerLottoNumbers = insertLottoNumbersControl();

        printBonusNumber();

        Player playerLotto = insertBonusNumberControl(playerLottoNumbers);

        List<Integer> gameResult = gameRule.calculateResult(cpu, playerLotto);
        String totalProfit = gameRule.calculateProfit(money, gameResult);

        OutputView.printResultMessage();
        OutputView.printContourLine();
        OutputView.printLottoResult(gameResult);
        OutputView.printTotalProfit(totalProfit);
    }

    public Cpu insertMoneyControl() {
        while (true) {
            try {
                int money = getValidInput(() -> InputView.insertMoney());
                Cpu cpu = new Cpu(money);
                return cpu;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto insertLottoNumbersControl() {
        while (true) {
            try {
                List<Integer> playerLottoNumbers = getValidInput(() -> InputView.insertLottoNumbers());
                Lotto playerLotto = new Lotto(playerLottoNumbers);
                return playerLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Player insertBonusNumberControl(Lotto playerLotto) {
        while (true) {
            try {
                int playerBonusNumber = getValidInput(() -> InputView.insertBonusNumber());
                return new Player(playerLotto, playerBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

