package lotto.controller;

import lotto.dto.LottoDto;
import lotto.service.LottoService;
import lotto.validator.InputValidator;
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
        drawAnswerLotto();
        calculateWinningResult();
        announceWinningResult();
    }

    private void buyLottos() {
        try {
            String inputPurchasePrice = inputView.askPurchasePrice();
            int purchasePrice = inputValidator.validateNumber(inputPurchasePrice);
            lottoService.buyLottos(purchasePrice);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            buyLottos();
        }
    }

    private void announceUserLotto() {
        List<LottoDto> lottoDtos = lottoService.getLottoDtos();
        outputView.printLottos(lottoDtos);
    }

    private void drawAnswerLotto() {
        try {
            List<Integer> lottoNumbers = drawLottoNumbers();
            int bonusNumber = drawBonusNumber();
            lottoService.drawAnswerLotto(lottoNumbers, bonusNumber);
        } catch (IllegalArgumentException e)  {
            outputView.printErrorMessage(e.getMessage());
            drawAnswerLotto();
        }
    }

    private List<Integer> drawLottoNumbers() {
        String inputLottoNumbers = inputView.askLottoNumbers();

        List<String> splitLottoNumbers = Arrays.stream(inputLottoNumbers.split(",")).toList();
        List<String> trimLottoNumbers = splitLottoNumbers.stream().map(String::trim).toList();

        return inputValidator.validateNumbers(trimLottoNumbers);
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
