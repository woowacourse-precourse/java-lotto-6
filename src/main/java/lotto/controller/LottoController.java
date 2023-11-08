package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void startLotto() {
        buyLotto();

        outputNewLine();
        outputPurchasedLotto();
        outputNewLine();

        createWinningLotto();
        countWinningNumber();

        outputWinningStatistics();
        outputRateOfReturn();
    }

    private void countWinningNumber() {
        lottoService.countWinningNumber();
    }

    private void outputRateOfReturn() {
        outputView.outputRateOfReturn(lottoService.calculateRateOfReturn());
    }

    private void outputWinningStatistics() {
        outputView.outputWinningStatistics();
        outputView.outputFifthPlace(lottoService.getThreeWins());
        outputView.outputFourthPlace(lottoService.getFourWins());
        outputView.outputThirdPlace(lottoService.getFiveWins());
        outputView.outputSecondPlace(lottoService.getFiveAndBonusWins());
        outputView.outputFirstPlace(lottoService.getSixWins());
    }

    private void createWinningLotto() {
        inputWinningNumber();
        inputBonusNumber();
    }

    private void inputWinningNumber() {
        boolean success = false;

        while (!success) {
            try {
                String winningNumber = inputView.inputWinningNumber();
                lottoService.createWinningLotto(winningNumber);
                success = true;
            } catch (IllegalArgumentException e) {
                outputView.outputErrorMessage(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        boolean success = false;

        while (!success) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                lottoService.addBonusNumber(bonusNumber);
                success = true;
            } catch (IllegalArgumentException e) {
                outputView.outputErrorMessage(e.getMessage());
            }
        }
    }

    private void outputNewLine() {
        outputView.outputNewLine();
    }

    private void outputPurchasedLotto() {
        outputNumberOfPurchases();
        outputLotto();
    }

    private void buyLotto() {
        boolean success = false;

        while (!success) {
            try {
                int lottoAmount = Integer.parseInt(inputView.inputLottoAmount());
                lottoService.buyLotto(lottoAmount);
                success = true;
            } catch (IllegalArgumentException e) {
                outputView.outputErrorMessage(e.getMessage());
            }
        }
    }

    private void outputNumberOfPurchases() {
        outputView.outputNumberOfPurchases(lottoService.getLottoNumbers());
    }

    private void outputLotto() {
        for (int i = 0; i < lottoService.getLottoNumbers(); i++) {
            outputView.outputLotto(lottoService.getLotto(i));
        }
    }
}
