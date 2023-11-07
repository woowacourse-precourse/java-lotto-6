package lotto.controller;

import lotto.model.LottoDatas;
import lotto.service.LottoService;
import lotto.view.InputView;

public class GameController {

    private final LottoService lottoService;
    private final LottoDatas lottoDatas;

    public GameController() {
        this.lottoDatas = new LottoDatas();
        this.lottoService = new LottoService(lottoDatas);
    }

    public void run() {
        inputPurchase();
        printLotto();
        inputLottoNumbers();
        printFinalPrize();
    }

    private void inputPurchase() {
        while (true) {
            String inputPurchase = InputView.InputPurchase();
            try {
                lottoService.convertPurchaseToCount(inputPurchase);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLotto() {

    }

    private void inputLottoNumbers() {

    }

    private void printFinalPrize() {

    }
}
