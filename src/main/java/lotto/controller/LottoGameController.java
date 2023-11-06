package lotto.controller;

import lotto.model.LottoGameManager;
import lotto.view.InputView;
import lotto.view.OutputMessage;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final LottoGameManager lottoGameManager;

    public LottoGameController(InputView inputView, LottoGameManager lottoGameManager) {
        this.inputView = inputView;
        this.lottoGameManager = lottoGameManager;
    }

    public void gameStart() {
        buyLotto();
        inputWiningNumbers();
        inputBonusNumber();
    }

    private void buyLotto() {
        while (true) {
            try {
                printLottoCostRequest();
                publishLotto();
                printPublishedLotto();
                break;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private void printLottoCostRequest() {
        OutputView.writeLine(OutputMessage.REQUEST_LOTTO_COST.message());
    }

    private void publishLotto() {
        String userInputLottoCost = inputView.readLine();
        lottoGameManager.createLottoBucket(userInputLottoCost);
    }

    private void printPublishedLotto() {
        OutputView.writeLine(lottoGameManager.showPublishedLotto());
    }

    private void inputWiningNumbers() {
        while (true) {
            try {
                printWinningNumbersRequest();
                publishWinningLotto();
                break;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private void printWinningNumbersRequest() {
        OutputView.writeLine(OutputMessage.REQUEST_WINNING_NUMBERS.message());
    }

    private void publishWinningLotto() {
        String userInputWinningNumbers = inputView.readLine();
        lottoGameManager.createWinningLotto(userInputWinningNumbers);
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                printBonusNumberRequest();
                requestBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private void printBonusNumberRequest() {
        OutputView.writeLine(OutputMessage.REQUEST_BONUS_NUMBER.message());
    }

    private void requestBonusNumber() {
        String userInputBonusNumbers = inputView.readLine();
        lottoGameManager.parsingBonusNumber(userInputBonusNumbers);
    }

    private void printErrorMessage(IllegalArgumentException e) {
        OutputView.writeLine(e.getMessage());
    }
}
