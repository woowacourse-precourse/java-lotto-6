package lotto;

import lotto.models.Machine;
import lotto.models.User;
import lotto.views.GameView;

public class GameManager {
    private User user;
    private Machine machine;
    private GameView gameView;

    public GameManager(){
        user = new User();
        machine = new Machine();
        gameView = new GameView();
    }

    public void play(){
        user.setMoney(gameView.purchaseAmountView());
        while(user.hasMoney()){
            user.buyLottery(machine);
        }
        gameView.lotteriesView(user.getLotteries());
        machine.setNumbers(gameView.winningNumberView());
        machine.setBonus(gameView.bonusView(machine.getLotto()));
        user.collectPrize(machine);
        gameView.statisticView(user.getPrizes());
        gameView.resultView(user.getUseMoney(), machine.getPayMoney());
    }
}
