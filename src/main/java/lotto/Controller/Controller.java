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

    private void startGame() {
        insertPlayerMoney();
        issuanceLotto();
    }
    private void proceedGame(){
        createAnswerLotto();
        createBonusNumber();
    }

    private void issuanceLotto(){
        gameModel.lottoIssuance();
        ArrayList<LottoData> playerLottos = gameModel.transferPlayerLottoDatas();
        Output.printLottos(playerLottos);
    }

    private void insertPlayerMoney(){
        boolean errorChecker = true;
        while (errorChecker) {
            try {
                Output.printEnterPurchaseMount();
                Integer playerInsert = Input.insertInteger();
                gameModel.initGameModel(playerInsert);
                errorChecker=false;
            }catch (IllegalArgumentException error){
                Output.printError(error.getMessage());
            }
        }
    }
    private void createAnswerLotto(){
        boolean errorChecker = true;
        while (errorChecker) {
            try {
                Output.printInsertLottoNumbers();
                String playerInsert = Input.insertString();
                gameModel.initAnswerByStrings(playerInsert);
                errorChecker=false;
            }catch (IllegalArgumentException error){
                Output.printError(error.getMessage());
            }
        }
    }
    private void createBonusNumber(){
        boolean errorChecker = true;

        while (errorChecker) {
            try {

                Output.printInsertBonusNumber();
                Integer insertBonusNumber = Input.insertInteger();
                gameModel.initBonus(insertBonusNumber);

                errorChecker=false;
            }catch (IllegalArgumentException error){
                Output.printError(error.getMessage());
            }
        }
    }

    private void finshGame(){
        makeTotalScore();
        makeTotalEarnRate();
    }

    private void makeTotalScore(){
        ScoreBoard scoreBoard = gameModel.getRoundScore();
        Output.printScores(scoreBoard);
    }

    private void makeTotalEarnRate(){
        Double earnLate = gameModel.getRoundEarnRate();
        Output.printEarnRate(earnLate);
    }
}
