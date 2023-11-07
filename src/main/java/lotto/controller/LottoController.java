package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
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
        UserMoney userMoney = lottoService.initUserMoney(inputUserMoney());
        WinningLottoNumbers winningLottoNumbers = lottoService.initWinningLottoNumbers(inputWinningLottoNumbers());
        BonusNumber bonusNumber = lottoService.initBonusNumber(winningLottoNumbers, inputBonusNumber());
        endGame();
    }

    private long inputUserMoney() {
        try {
            return askToInsertUserMoney();
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputUserMoney();
        }
    }

    private long askToInsertUserMoney() {
        outputView.askToInsertUserMoney();
        return inputView.getUserMoney();
    }

    private List<Long> inputWinningLottoNumbers() {
        try {
            return askToInsertWinningLottoNumbers();
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputWinningLottoNumbers();
        }
    }

    private List<Long> askToInsertWinningLottoNumbers() {
        outputView.askUserToInsertLottoWinningNumbers();
        return inputView.getWinningLottoNumbers();
    }

    private long inputBonusNumber() {
        try {
            return askToInsertBonusNumber();
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputBonusNumber();
        }
    }

    private long askToInsertBonusNumber() {
        outputView.askUserToInsertBonusNumber();
        return inputView.getBonusNumber();
    }

    private void endGame() {
        Console.close();
    }
}