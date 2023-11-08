package lotto.controller;

import static lotto.enums.InputMessages.INPUT_AMOUNT_MESSAGE;
import static lotto.enums.InputMessages.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.enums.InputMessages.INPUT_WINNING_LOTTO_NUMBER_MESSAGE;

import lotto.domain.LottoResultManager;
import lotto.domain.User;
import lotto.view.InputManager;
import lotto.view.OutputManager;

public class LottoRunner {
    private static LottoRunner lottoRunner;
    private InputManager inputManager;
    private OutputManager outputManager;
    private User user;
    private LottoResultManager lottoResultManager;

    private LottoRunner() {
        this.inputManager = new InputManager();
        this.outputManager = new OutputManager();
        this.lottoResultManager = new LottoResultManager();
    }

    public void runLottoApp() {
        this.user = inputAmount();
        outputManager.printUserLottos(user);
        inputWinningLottoNumbers(lottoResultManager);
        inputBonusNumber(lottoResultManager);
        user.saveLottoRankResult(lottoResultManager.getWinningLotto(), lottoResultManager.getBonusNumber());
        user.calculateProfitability();
        outputManager.printLottoProfit(user);
    }

    private User inputAmount() {
        User user;
        while (true) {
            try {
                String amount = inputManager.inputValue(INPUT_AMOUNT_MESSAGE.getMessage());
                user = new User(amount);
                break;
            } catch (IllegalArgumentException error) {
                outputManager.printMessage(error.getMessage());
            }
        }
        return user;
    }

    private void inputWinningLottoNumbers(LottoResultManager lottoResultManager) {
        while (true) {
            try {
                String winningNumbers = inputManager.inputValue(INPUT_WINNING_LOTTO_NUMBER_MESSAGE.getMessage());
                lottoResultManager.setWinningLotto(winningNumbers);
                break;
            } catch (IllegalArgumentException error) {
                outputManager.printMessage(error.getMessage());
            }
        }
    }

    private void inputBonusNumber(LottoResultManager lottoResultManager) {
        while (true) {
            try {
                String bonusNumber = inputManager.inputValue(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
                lottoResultManager.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException error) {
                outputManager.printMessage(error.getMessage());
            }
        }
    }

    public static LottoRunner getLottoRunner() {
        if (lottoRunner == null) {
            return new LottoRunner();
        }
        return lottoRunner;
    }
}

