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
        generateLottoUsePurchaseAmount();
        printLottoNumbers(getLottoNumbers());
        getWinningLotto();
        getBonusNumber();
    }

    private void generateLottoUsePurchaseAmount() {
        try {
            int purchaseAmount = readPurchaseAmount();
            makeLottoByPurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateLottoUsePurchaseAmount();
        }
    }

    private void getWinningLotto() {
        try {
            readWinningLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getWinningLotto();
        }
    }

    private void getBonusNumber() {
        try {
            readBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readWinningLotto();
        }
    }

    private int readPurchaseAmount() throws IllegalArgumentException{
        return inputView.readPurchaseAmount();
    }

    private void makeLottoByPurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        lottoService.makeLottoByPurchaseAmount(purchaseAmount);
    }

    private void printLottoNumbers(String lottos) {
        outputView.printLottos(lottos);
    }

    private String getLottoNumbers() {
        return lottoService.getLottoNumbers();
    }

    private String readWinningLotto() throws IllegalArgumentException {
        return inputView.readWinningLotto();
    }

    private String readBonusNumber() throws IllegalArgumentException {
        return inputView.readBonusNumber();
    }

    private void makeWinningLotto(String winningLotto, String bonusNumber) {
        lottoService.makeWinningLotto(winningLotto, bonusNumber);
    }
}
