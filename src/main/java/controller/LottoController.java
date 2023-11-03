package controller;

import java.util.List;
import model.FinanceManager;
import model.GameManager;
import model.LottoTotalResult;
import model.dto.LottoResponse;
import model.dto.AnswerBonusNumber;
import model.dto.AnswerLottoNumbers;
import model.dto.LottoResult;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private FinanceManager financeManager;
    private GameManager gameManager;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initGame();
        informLottos();
        generateAnswerNumber();
        informLottoResult();
    }

    private void informLottoResult() {
        LottoTotalResult totalResult = gameManager.calculateResult();
        informWinningResult(totalResult);
        informRateOfReturn(totalResult);
    }

    private void informRateOfReturn(final LottoTotalResult totalResult) {
        double rateOfReturn = financeManager.calculateRateOfReturn(totalResult);
        outputView.informRateOfReturn(rateOfReturn);
    }

    private void informWinningResult(final LottoTotalResult totalResult) {
        List<LottoResult> results = totalResult.toDto();
        outputView.informWinningStatistics(results);
    }

    private void generateAnswerNumber() {
        AnswerLottoNumbers answerLottoNumbers = getValidUserLottoNumbers();
        AnswerBonusNumber answerBonusNumber = getUserBonusNumber();

        gameManager.generateAnswerLotto(answerLottoNumbers, answerBonusNumber);
    }

    private AnswerBonusNumber getUserBonusNumber() {
        outputView.askBonusNumber();
        return new AnswerBonusNumber(inputView.read());
    }

    private AnswerLottoNumbers getValidUserLottoNumbers() {
        outputView.askLottoNumbers();
        return new AnswerLottoNumbers(inputView.read());
    }

    private void informLottos() {
        outputView.informLottoCount(financeManager.calculateLottoCount());
        List<LottoResponse> lottoResponses = gameManager.getGeneratedLottos();
        outputView.noticeGeneratedLottos(lottoResponses);
    }

    private void initGame() {
        initFinanceManager();
        initGameManager();
    }

    private void initFinanceManager() {
        outputView.askPurchaseAmount();
        String inputPurchase = inputView.read();
        while (!FinanceManager.isValidArgument(inputPurchase)) {
            inputPurchase = inputView.read();
        }

        financeManager = FinanceManager.from(inputPurchase);
    }

    private void initGameManager() {
        int lottoCount = financeManager.calculateLottoCount();
        gameManager = GameManager.createDefault(lottoCount);
    }
}
