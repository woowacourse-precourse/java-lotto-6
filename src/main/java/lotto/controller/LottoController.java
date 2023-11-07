package lotto.controller;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.prize.WinningDetails;
import lotto.service.LottoService;
import lotto.util.InputConverter;
import lotto.util.InputValidator;
import lotto.util.LottoConstants;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    private LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LottoController getInstance() {
        return new LottoController(LottoService.getInstance(), new InputView(), new OutputView());
    }

    public void run() {
        performLottosPurchaseProcess();
        performDrawWinningLottoProcess();
        performLottoResultProcess();
        performProfitRateCalculationProcess();
    }

    private void performLottosPurchaseProcess() {
        try {
            int purchaseAmount = InputValue(inputView.askPurchaseAmount());
            outputView.nextLine();
            List<String> issuedLottosNumbers = lottoService.buyLotto(purchaseAmount);
            outputView.showIssuedLottoResult(issuedLottosNumbers);
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            performLottosPurchaseProcess();
        }
    }

    private void performDrawWinningLottoProcess() {
        try {
            outputView.nextLine();
            final List<Integer> winningNumbers = InputWinnigNumbers();
            outputView.nextLine();
            final int bonusNumber = InputValue(inputView.askBonusNumber());
            lottoService.drawWinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            performDrawWinningLottoProcess();
        }
    }

    private void performProfitRateCalculationProcess() {
        double profitRate = lottoService.getProfitRate();
        outputView.showProfitRate(profitRate);
    }

    private void performLottoResultProcess() {
        outputView.nextLine();
        final WinningDetails winningDetails = lottoService.getWinningResult();
        outputView.showLottoResult(winningDetails);
    }

    private int InputValue(String input) {
        InputValidator.validateInput(input);

        return InputConverter.convertStringToInt(input);
    }

    private List<Integer> InputWinnigNumbers() {
        String winningNumbers = inputView.askWinnigNumbers();

        return InputConverter.convertToList(winningNumbers);
    }
}
