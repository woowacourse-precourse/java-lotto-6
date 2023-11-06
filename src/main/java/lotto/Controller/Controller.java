package lotto.Controller;

import lotto.Model.GameModel;
import lotto.View.Input;
import lotto.View.Output;

public class Controller {
    private GameModel gameModel;

    public void playingGame(){
        initGame();
        startGame();
    }

    private void initGame(){
        gameModel = new GameModel();
    }
    private void startGame(){
        Output.printEnterPurchaseMount();
        Integer playerInsert = Input.insertInteger();
        gameModel.lottoIssuance(playerInsert);

    }
}
