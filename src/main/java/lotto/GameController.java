package lotto;

import java.util.List;

public class GameController {

    GameRule gameRule = new GameRule();
    InputView inputView = new InputView(new InputValidator());
    OutputView outputView = new OutputView();

    public void runGame() {
        inputView.printInsertMoney();
        int money = inputView.insertMoney();
        Cpu cpu = new Cpu(money);
        int tickets = cpu.getTickets();

        outputView.printBuyTickets(tickets);
        outputView.printLottoNumbers(cpu, tickets);

        inputView.printInsertLottoNumbers();
        List<Integer> playerLottoNumbers = inputView.insertLottoNumbers();

        inputView.printBonusNumber();
        int playerBonusNumber = inputView.insertBonusNumber();

        Player playerLotto = new Player(new Lotto(playerLottoNumbers), playerBonusNumber);

        List<Integer> gameResult = gameRule.calculateResult(cpu, playerLotto);
        String totalProfit = gameRule.calculateProfit(money, gameResult);

        outputView.printResultMessage();
        outputView.printContourLine();
        outputView.printLottoResult(gameResult);
        outputView.printTotalProfit(totalProfit);
    }

}
