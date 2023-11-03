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
        initLotto();
        progressLotto(initWinning(), initBonus());
        finishLotto();
    }

    private void initLotto(){
        Money money = null;
        do{
            try{
                outputView.printMoney();
                money = inputView.getMoney();
            } catch (IllegalArgumentException e){
                outputView.printMessage(e.getMessage());
            }
        } while(money == null);
        player = new Player(money);
        player.buyLotto();
        outputView.printBuying(player.checkLotto());
    }

    private Winning initWinning(){
        Winning winning = null;
        do{
            try{
                outputView.printWinning();
                winning = inputView.getWinning();
            } catch (IllegalArgumentException e){
                outputView.printMessage(e.getMessage());
            }
        } while(winning == null);
        return winning;
    }

    private Bonus initBonus(){
        Bonus bonus = null;
        do{
            try{
                outputView.printBonus();
                bonus = inputView.getBonus();
            } catch (IllegalArgumentException e){
                outputView.printMessage(e.getMessage());
            }
        } while(bonus == null);
        return bonus;
    }

    private void progressLotto(Winning winning, Bonus bonus){
        player.announceWinning(winning, bonus);
    }

    private void finishLotto(){
        outputView.printStatistics(player.checkWinning(), player.calculateYield());
    }

}
