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
        printLottoNumbers(getLottoNumbers(), getLottoNum());
        getBonusNumber(getWinningLotto());
        compareLottoWithWinningLotto();
        printLottoRate(generateLottoRate(), getLottoWinningRate());
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

    private String getWinningLotto() {
        try {
            return readWinningLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private void getBonusNumber(String winningLotto) {
        try {
            makeWinningLotto(winningLotto, readBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getBonusNumber(winningLotto);
        }
    }

    private int readPurchaseAmount() throws IllegalArgumentException {
        return inputView.readPurchaseAmount();
    }

    private void makeLottoByPurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        lottoService.makeLottoByPurchaseAmount(purchaseAmount);
    }

    private void printLottoNumbers(String lottos, int lottoNum) {
        outputView.printLottos(lottos, lottoNum);
    }

    private String getLottoNumbers() {
        return lottoService.getLottoNumbers();
    }

    private int getLottoNum() {
        return lottoService.getLottoNum();
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

    private void compareLottoWithWinningLotto() {
        lottoService.compareLottoWithWinningLotto();
    }

    private String generateLottoRate() {
        return lottoService.generateLottoRate();
    }

    private double getLottoWinningRate() {
        return lottoService.getLottoWinningRate();
    }

    private void printLottoRate(String lottoRate, double lottoWinningRate) {
        outputView.printLottoRate(lottoRate, lottoWinningRate);
    }
}
