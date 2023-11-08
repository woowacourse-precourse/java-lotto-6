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

        outputPurchasedLotto();
        outputNewLine();

        createWinningLotto();

        outputWinningStatistics();
        outputRateOfReturn();
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
        lottoService.createWinningLotto(inputWinningNumber());
        lottoService.addBonusNumber(inputBonusNumber());
    }

    private String inputWinningNumber() {
        String winningNumber = null;
        boolean success = false;

        while (!success) {
            try {
                winningNumber = inputView.inputWinningNumber();
                success = true;
            } catch (IllegalArgumentException e) {
                outputView.outputErrorMessage(e.getMessage());
            }
        }
        return winningNumber;
    }

    private String inputBonusNumber() {
        String bonusNumber = null;
        boolean success = false;

        while (!success) {
            try {
                bonusNumber = inputView.inputBonusNumber();
                success = true;
            } catch (IllegalArgumentException e) {
                outputView.outputErrorMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private void outputNewLine() {
        outputView.outputNewLine();
    }

    private void outputPurchasedLotto() {
        outputNumberOfPurchases();
        outputLotto();
    }

    private void buyLotto() {
        lottoService.buyLotto(inputLottoAmount());
    }

    private void outputNumberOfPurchases() {
        outputView.outputNumberOfPurchases(lottoService.getLottoNumbers());
    }

    private void outputLotto() {
        for (int i = 0; i < lottoService.getLottoNumbers(); i++) {
            outputView.outputLotto(lottoService.getLotto(i));
        }
    }

    private int inputLottoAmount() {
        int lottoAmount = 0;
        boolean success = false;

        while (!success) {
            try {
                lottoAmount = Integer.parseInt(inputView.inputLottoAmount());
                success = true;
            } catch (IllegalArgumentException e) {
                outputView.outputErrorMessage(e.getMessage());
            }
        }
        return lottoAmount;
    }
}
