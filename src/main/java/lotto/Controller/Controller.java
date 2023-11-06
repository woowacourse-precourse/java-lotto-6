package lotto.Controller;

import java.util.ArrayList;
import lotto.Model.GameModel;
import lotto.Model.VO.LottoData;
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
        ArrayList<LottoData> playerLottos = gameModel.transferPlayerLottoDatas();
        Output.printLottos(playerLottos);
    }
}
