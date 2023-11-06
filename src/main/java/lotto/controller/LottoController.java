package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.exception.LottoInputException;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void playGame() {
        UserMoney userMoney = getUserMoney();
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        askUserToInsertBonusNumber();
        lottoService.playGame();
        endGame();
    }

    private UserMoney getUserMoney() {
        try {
            return askToInsertUserMoney();
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return getUserMoney();
        }
    }

    private UserMoney askToInsertUserMoney() {
        outputView.askToInsertUserMoney();
        return inputView.getUserMoney();
    }

    private WinningLottoNumbers getWinningLottoNumbers() {
        try {
            return askToInsertWinningLottoNumbers();
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return getWinningLottoNumbers();
        }
    }

    private WinningLottoNumbers askToInsertWinningLottoNumbers() {
        outputView.askUserToInsertLottoWinningNumbers();
        return inputView.getWinningLottoNumbers();
    }

    private void askUserToInsertBonusNumber(){
        outputView.askUserToInsertBonusNumber();
    }

    private void endGame(){
        Console.close();
    }
}