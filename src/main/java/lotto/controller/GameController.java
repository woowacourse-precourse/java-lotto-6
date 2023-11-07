package lotto.controller;

import lotto.model.LottoDatas;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final LottoService lottoService;
    private final LottoDatas lottoDatas;

    public GameController() {
        this.lottoDatas = new LottoDatas();
        this.lottoService = new LottoService(lottoDatas);
    }

    public void run() {
        inputPurchase();
        lottoDatas.generateLottoNumbers();
        printLotto();
        inputWinningNumber();
        printFinalPrize();
    }

    private void inputPurchase() {
        while (true) {
            String inputPurchase = InputView.inputPurchase();
            try {
                lottoService.convertPurchaseToCount(inputPurchase);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printLotto() {

    }

    private void inputWinningNumber() {
        while (true) {
            String inputLottoNumbers = InputView.inputWinningNumbers();
            try {
                lottoService.convertToIntegerList(inputLottoNumbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printFinalPrize() {

    }
}
