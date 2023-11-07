package lotto.Controller;

import java.util.ArrayList;
import lotto.Model.GameModel;
import lotto.Model.ScoreBoard;
import lotto.Model.VO.LottoData;
import lotto.View.Input;
import lotto.View.Output;

public class Controller {
    private GameModel gameModel;

    public void playingGame(){
        startGame();
        proceedGame();
        finshGame();
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

        Output.printInsertLottoNumbers();
        String playerInsert = Input.insertString();
        gameModel.initAnswerByStrings(playerInsert);

        Output.printInsertBonusNumber();
        Integer insertBonusNumber = Input.insertInteger();
        gameModel.initBonus(insertBonusNumber);
    }

    private void finshGame(){
        ScoreBoard scoreBoard = gameModel.calculateRoundScore();
        Output.printScores(scoreBoard);
    }

}
