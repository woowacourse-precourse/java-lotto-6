package lotto.Controller;

import lotto.Model.GameModel;
import lotto.View.Input;
import lotto.View.Output;

public class Controller {
    private GameModel gameModel;

    public void playingGame(){
        startGame();
        proceedGame();
    }

    public Controller(){
        gameModel = new GameModel();
    }
    private void startGame(){
        Output.printEnterPurchaseMount();
        Integer playerInsert = Input.insertInteger();
        gameModel.initGameModel(playerInsert);
    }

    private void proceedGame(){
        gameModel.lottoIssuance();
    }
}
