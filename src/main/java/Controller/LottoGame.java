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
        progressLotto();
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

    private void progressLotto(){
        Winning winning = initWinning();
        Bonus bonus = initBonus(winning);
        player.announceWinning(winning, bonus);
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

    private Bonus initBonus(Winning winning){
        Bonus bonus = null;
        do{
            try{
                outputView.printBonus();
                bonus = inputView.getBonus(winning);
            } catch (IllegalArgumentException e){
                outputView.printMessage(e.getMessage());
            }
        } while(bonus == null);
        return bonus;
    }



    private void finishLotto(){
        outputView.printStatistics(player.checkWinning(), player.calculateYield());
    }

}
