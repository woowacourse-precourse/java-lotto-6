package lotto;

import static lotto.InputController.getValidInput;

import java.util.List;
import lotto.Constants.IntConstants;

public class GameController {

    GameRule gameRule = new GameRule();
    InputView inputView = new InputView(new InputValidator());
    OutputView outputView = new OutputView();
    
    public void runGame() {
        inputView.printInsertMoney();
        Cpu cpu = insertMoneyControl();
        int tickets = cpu.getTickets();
        int money = tickets * IntConstants.UNIT_BILL.getValue();
        outputView.printBuyTickets(tickets);
        outputView.printLottoNumbers(cpu, tickets);

        inputView.printInsertLottoNumbers();
        Lotto playerLottoNumbers = insertLottoNumbersControl();

        inputView.printBonusNumber();

        Player playerLotto = insertBonusNumberControl(playerLottoNumbers);

        List<Integer> gameResult = gameRule.calculateResult(cpu, playerLotto);
        String totalProfit = gameRule.calculateProfit(money, gameResult);

        outputView.printResultMessage();
        outputView.printContourLine();
        outputView.printLottoResult(gameResult);
        outputView.printTotalProfit(totalProfit);
    }

    public Cpu insertMoneyControl() {
        while (true) {
            try {
                int money = getValidInput(() -> inputView.insertMoney());
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
                List<Integer> playerLottoNumbers = getValidInput(() -> inputView.insertLottoNumbers());
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
                int playerBonusNumber = getValidInput(() -> inputView.insertBonusNumber());
                return new Player(playerLotto, playerBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

