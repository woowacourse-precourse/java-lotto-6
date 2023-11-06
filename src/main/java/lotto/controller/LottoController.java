package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserMoney;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.exception.LottoInputException;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void playGame(){
        UserMoney userMoney;
        try {
            userMoney = askToInsertUserMoney();
        } catch(LottoInputException e){
            outputView.printErrorMessage(e.getMessage());
            playGame();
        }
        askUserToInsertLottoWinningNumbers();
        askUserToInsertBonusNumber();
        lottoService.playGame();
        endGame();
    }

    private UserMoney askToInsertUserMoney(){
        outputView.askToInsertUserMoney();
        return inputView.getUserMoney();
    }

    private void askUserToInsertLottoWinningNumbers(){
        outputView.askUserToInsertLottoWinningNumbers();
    }

    private void askUserToInsertBonusNumber(){
        outputView.askUserToInsertBonusNumber();
    }

    private void endGame(){
        Console.close();
    }
}