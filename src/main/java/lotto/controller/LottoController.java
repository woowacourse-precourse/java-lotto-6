package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;
    private static LottoController instance;

    private LottoController() {
        lottoService = LottoService.getInstance();
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public static LottoController getInstance() {
        if (instance == null) {
            instance = new LottoController();
        }
        return instance;
    }

    public void run() {
        lottoStart();
    }

    private void lottoStart() {
        String purchaseAmount = readPurchaseAmount();
        makeLottoByPurchaseAmount(purchaseAmount);
        printLottoNumbers(getLottoNumbers());
    }

    private String readPurchaseAmount() {
        return inputView.readPurchaseAmount();
    }

    private void makeLottoByPurchaseAmount(String purchaseAmount) {
        lottoService.makeLottoByPurchaseAmount(purchaseAmount);
    }

    private void printLottoNumbers(String lottos) {
        outputView.printLottos(lottos);
    }

    private String getLottoNumbers() {
        return lottoService.getLottoNumbers();
    }
}
