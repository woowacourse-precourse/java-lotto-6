package controller;

import java.util.List;
import model.LottoTotalResult;
import model.dto.LottoResponse;
import model.dto.AnswerLottoNumbers;
import model.dto.LottoResult;
import service.LottoService;
import validator.LottoValidator;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoValidator validator;
    private LottoService lottoService;

    public LottoController(final InputView inputView, final OutputView outputView,
        final LottoValidator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public void run() {
        initService();
        informLottos();
        generateAnswerNumber();
        informLottoResult();
        inputView.close();
    }

    private void initService() {
        int purchase = askValidPurchaseAmount();
        lottoService = LottoService.from(purchase);
    }

    private int askValidPurchaseAmount() {
        outputView.askPurchaseAmount();
        String inputPurchase = inputView.read();
        try {
            validator.validatePurchase(inputPurchase);
            return Integer.parseInt(inputPurchase);
        } catch (IllegalArgumentException exception) {
            outputView.showErrorMessage(exception.getMessage());
            return askValidPurchaseAmount();
        }
    }

    private void informLottos() {
        outputView.informLottoCount(lottoService.getLottoCount());
        List<LottoResponse> lottoResponses = lottoService.getGeneratedLottos();
        outputView.noticeGeneratedLottos(lottoResponses);
    }

    private void generateAnswerNumber() {
        List<Integer> answerLottoNumbers = getValidAnswerNumbers();
        int answerBonusNumber = getValidBonusNumber(answerLottoNumbers);

        lottoService.generateAnswerLotto(answerLottoNumbers, answerBonusNumber);
    }

    private List<Integer> getValidAnswerNumbers() {
        outputView.askLottoNumbers();
        AnswerLottoNumbers answerNumbers = new AnswerLottoNumbers(inputView.read());
        try {
            validator.validateAnswerNumbers(answerNumbers);
            return answerNumbers.divideNumbers()
                .stream()
                .map(Integer::parseInt)
                .toList();
        } catch (IllegalArgumentException exception) {
            outputView.showErrorMessage(exception.getMessage());
            return getValidAnswerNumbers();
        }
    }

    private int getValidBonusNumber(final List<Integer> numbers) {
        outputView.askBonusNumber();
        String inputBonusNumber = inputView.read();
        try {
            validator.validateBonusNumber(numbers, inputBonusNumber);
            return Integer.parseInt(inputBonusNumber);
        } catch (IllegalArgumentException exception) {
            outputView.showErrorMessage(exception.getMessage());
            return getValidBonusNumber(numbers);
        }
    }
    private void informLottoResult() {
        LottoTotalResult totalResult = lottoService.calculateResult();
        informWinningResult(totalResult);
        informRateOfReturn(totalResult);
    }

    private void informRateOfReturn(final LottoTotalResult totalResult) {
        double rateOfReturn = lottoService.calculateRateOfReturn(totalResult);
        outputView.informRateOfReturn(rateOfReturn);
    }

    private void informWinningResult(final LottoTotalResult totalResult) {
        List<LottoResult> results = totalResult.toDto();
        outputView.informWinningStatistics(results);
    }
}
