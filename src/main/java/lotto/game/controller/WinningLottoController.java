package lotto.game.controller;

import java.util.List;
import lotto.adapter.IoAdapter;
import lotto.domain.WinnerNumbers;
import lotto.message.ErrorMessage;
import lotto.message.LottoMessage;
import lotto.service.ValidateService;

public class WinningLottoController {

    private final IoAdapter ioAdapter;

    private final ValidateService validateService;


    public WinningLottoController(IoAdapter ioAdapter, ValidateService validateService) {
        this.ioAdapter = ioAdapter;
        this.validateService = validateService;
    }

    public WinnerNumbers make() {
        while (true) {
            try {
                List<Integer> winnerNumbers = makeWinnerNumber();
                Integer bonusNumber = makeBonusNumber();
                return new WinnerNumbers(winnerNumbers, bonusNumber);
            } catch (IllegalArgumentException exception) {
                ErrorMessage wrongLottoError = ErrorMessage.WRONG_LOTTO_ERROR;
                ioAdapter.printMessage(wrongLottoError.getMessage());
            }
        }
    }

    private Integer makeBonusNumber() {
        while (true) {
            try {
                LottoMessage bonusNumberMessage = LottoMessage.INSERT_BONUS_NUMBER;
                ioAdapter.printMessage(bonusNumberMessage.getMessage());
                String bonusNumberInput = ioAdapter.inputStream();
                Integer bonusNumber = validateService.checkIncludeChar(bonusNumberInput);
                ioAdapter.printNewLine();
                return bonusNumber;
            } catch (IllegalArgumentException exception) {
                ErrorMessage BonusNumberError = ErrorMessage.ENTER_BONUS_NUMBER_ERROR;
                ioAdapter.printMessage(BonusNumberError.getMessage());
            }
        }
    }

    private List<Integer> makeWinnerNumber() {
        while (true) {
            try {
                LottoMessage insertWinningNumbersMessage = LottoMessage.INSERT_WINNING_NUMBERS;
                ioAdapter.printMessage(insertWinningNumbersMessage.getMessage());
                String winnerNumbersInput = ioAdapter.inputStream();
                List<Integer> winnerNumbers = validateService.checkCorrectWinnerNumbers(winnerNumbersInput);
                ioAdapter.printNewLine();
                return winnerNumbers;
            } catch (IllegalArgumentException exception) {
                ErrorMessage WinnerNumberError = ErrorMessage.ENTER_WINNER_NUMBER_ERROR;
                ioAdapter.printMessage(WinnerNumberError.getMessage());
            }
        }
    }
}
