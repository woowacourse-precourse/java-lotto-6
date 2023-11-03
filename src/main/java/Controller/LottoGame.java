package Controller;

import Model.Bonus;
import Model.Money;
import Model.Player;
import Model.Winning;
import View.InputView;
import View.OutputView;

public class LottoGame {

    private static Player player;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame(){
        initGame();
        progressGame();
        finishGame();
    }

    private void initGame(){
        outputView.printMoney();
        Money money = inputView.getMoney();
        player = new Player(money);
        player.buyLotto();
        outputView.printBuying(player.checkLotto());
    }

    private void progressGame(){
        outputView.printWinning();
        Winning winning = inputView.getWinning();
        outputView.printBonus();
        Bonus bonus = inputView.getBonus();
        player.announceWinning(winning, bonus);
    }

    private void finishGame(){
        outputView.printStatistics(player.checkWinning(), player.calculateYield());
    }

}
