package lotto.controller;

import lotto.service.GameService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final LottoService lottoService;

    public GameController(InputView inputView, OutputView outputView, GameService gameService, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.lottoService = lottoService;
    }

    public void run() {
        purchaseLottos();
        issueLottos();
        inputWinningLotto();
        inputBonusNumber();
        outputWinningStatistics();
        outputProfitRate();
    }

    public void purchaseLottos() {
        String input;
        do {
            outputView.requestPurchaseAmount();
            input = inputView.scanPurchaseAmount();
        } while (isInvalidPurchaseAmount(input));
    }

    public void issueLottos() {
        try {
            lottoService.initLottos(gameService.createLottos());
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            throw e;
        }
        outputView.printPurchaseNumber(gameService.getPurchaseNumber());
        outputView.printLottos(lottoService.getLottosOutput());
    }

    public void inputWinningLotto() {
        lottoService.initWinningNumbers();
        String input;
        do {
            outputView.requestWinningLotto();
            input = inputView.scanWinningLotto();
        } while (isInvalidWinningLotto(input));
    }

    public void inputBonusNumber() {
        String input;
        do {
            outputView.requestBonusNumber();
            input = inputView.scanBonusNumber();
        } while (isInvalidBonusNumber(input));
    }

    public void outputWinningStatistics() {
        gameService.initRankStatistics(lottoService.createStatistics());
        outputView.printRankStatistics(gameService.getRankStatisticsOutput());
    }

    public void outputProfitRate() {
        outputView.printProfitRate(gameService.getProfitRate());
    }

    private boolean isInvalidPurchaseAmount(String input) {
        try {
            gameService.initPurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return true;
        }
        return false;
    }

    private boolean isInvalidWinningLotto(String input) {
        try {
            lottoService.initWinningLotto(input);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return true;
        }
        return false;
    }

    private boolean isInvalidBonusNumber(String input) {
        try {
            lottoService.initBonusNumber(input);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return true;
        }
        return false;
    }
}
