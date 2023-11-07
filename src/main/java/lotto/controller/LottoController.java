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
        UserMoney userMoney = initUserMoney();
        WinningLottoNumbers winningLottoNumbers = initWinningLottoNumbers();
        BonusNumber bonusNumber = initBonusNumber(winningLottoNumbers);
        endGame();
    }

    private UserMoney initUserMoney() {
        try {
            long userMoney = askToInsertUserMoney();
            return lottoService.initUserMoney(userMoney);
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return initUserMoney();
        }
    }

    private long askToInsertUserMoney() {
        outputView.askToInsertUserMoney();
        return inputView.getUserMoney();
    }

    private WinningLottoNumbers initWinningLottoNumbers() {
        try {
            List<Long> winningLottoNumbers = askToInsertWinningLottoNumbers();
            return lottoService.initWinningLottoNumbers(winningLottoNumbers);
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return initWinningLottoNumbers();
        }
    }

    private List<Long> askToInsertWinningLottoNumbers() {
        outputView.askUserToInsertLottoWinningNumbers();
        return inputView.getWinningLottoNumbers();
    }

    private BonusNumber initBonusNumber(WinningLottoNumbers winningLottoNumbers) {
        try {
            long bonusNumber = askToInsertBonusNumber();
            return lottoService.initBonusNumber(winningLottoNumbers, bonusNumber);
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return initBonusNumber(winningLottoNumbers);
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