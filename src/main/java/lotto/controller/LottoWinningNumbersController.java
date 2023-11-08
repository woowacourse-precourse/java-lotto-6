package lotto.controller;

import static lotto.view.constant.InputMessage.GET_BONUS_NUMBER_MESSAGE;
import static lotto.view.constant.InputMessage.GET_WINNING_NUMBERS_MESSAGE;
import static lotto.view.constant.OutputMessage.NEWLINE;

import lotto.domain.LottoWinningNumbers;
import lotto.service.LottoWinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoWinningNumbersController {

    private final InputView inputView;
    private final LottoWinningNumbersService winningNumbersService;

    public LottoWinningNumbersController() {
        inputView = new InputView();
        winningNumbersService = new LottoWinningNumbersService();
    }

    public LottoWinningNumbers getLottoWinningNumbers() {
        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber(winningNumbers);
        return winningNumbersService.createLottoWinningNumbers(winningNumbers, bonusNumber);
    }

    public String getWinningNumbers() {
        OutputView.printMessage(GET_WINNING_NUMBERS_MESSAGE.getMessage());
        return inputView.readWinningNumbers();
    }

    public String getBonusNumber(String winningNumbers) {
        OutputView.printMessage(NEWLINE.getMessage() + GET_BONUS_NUMBER_MESSAGE.getMessage());
        return inputView.readBonusNumber(winningNumbers);
    }
}
