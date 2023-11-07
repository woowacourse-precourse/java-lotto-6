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
        gameView.purchaseAmountView();
        user.buyLotteries(machine);

    }
}
