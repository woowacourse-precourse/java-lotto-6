package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoBucket;
import lotto.model.LottoGameManager;
import lotto.model.LottoRanking;
import lotto.view.InputView;
import lotto.view.OutputMessage;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final LottoGameManager lottoGameManager;

    private Lotto winningLotto;
    private LottoBucket lottoBucket;

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
        lottoBucket = lottoGameManager.createLottoBucket(userInputLottoCost);
    }

    private void printPublishedLotto() {
        OutputView.writeLine(
                lottoBucket.getLottoAmount() + OutputMessage.RESPONSE_PURCHASED_LOTTO_AMOUNT.message());
        OutputView.writeLine(lottoBucket.showLottoBucket());
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
        winningLotto = lottoGameManager.createWinningLotto(userInputWinningNumbers);
    }

    private LottoRanking inputBonusNumber() {
        while (true) {
            try {
                printBonusNumberRequest();
                String userInputBonusNumbers = inputView.readLine();
                return lottoGameManager.createWinningLottoAddBonusNumber(winningLotto, userInputBonusNumbers);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private void printBonusNumberRequest() {
        OutputView.writeLine(OutputMessage.REQUEST_BONUS_NUMBER.message());
    }

    private void printErrorMessage(IllegalArgumentException e) {
        OutputView.writeLine(e.getMessage());
    }
}
