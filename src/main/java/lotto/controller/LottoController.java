package lotto.controller;

import lotto.dto.LottoDto;
import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.lottoService = new LottoService();
    }

    public void startLotto() {
        buyLottos();
        announceUserLotto();
        drawLotto();
        calculateWinningResult();
        announceWinningResult();
    }

    private void buyLottos() {
        String inputPurchasePrice = inputView.askPurchasePrice();
        int purchasePrice = inputValidator.validateNumber(inputPurchasePrice);
        lottoService.buyLottos(purchasePrice);
    }

    private void announceUserLotto() {
        List<LottoDto> lottoDtos = lottoService.getUserLottoDto();
        outputView.printUserLotto(lottoDtos);
    }

    private void drawLotto() {
        List<Integer> winningNumbers = drawWinningNumbers();
        int bonusNumber = drawBonusNumber();
        lottoService.drawLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> drawWinningNumbers() {
        String inputWinningNumbers = inputView.askWinningNumbers();
        List<String> splitWinningNumbers = Arrays.stream(inputWinningNumbers.split(",")).toList();
        return inputValidator.validateNumbers(splitWinningNumbers);
    }

    private int drawBonusNumber() {
        String inputBonusNumber = inputView.askBonusNumber();
        return inputValidator.validateNumber(inputBonusNumber);
    }

    private void calculateWinningResult() {
        lottoService.calculateWinningResult();
    }

    private void announceWinningResult() {
        outputView.printWinningResult(lottoService.getWinningResultDto());
    }
}
